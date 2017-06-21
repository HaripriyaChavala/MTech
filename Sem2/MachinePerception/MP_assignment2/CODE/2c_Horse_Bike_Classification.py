import cv2
import numpy as np
import os
from scipy.cluster.vq import *
import glob
import math
from sklearn.preprocessing import StandardScaler

K = 500
numToLabel = { 0 : "horse", 1 : "bike"}
labelToNum = { "horse" : 0, "bike" : 1}

def learning():
	
	trainData = []
	labels = []
	descriptorList = []

	# Using SIFT for interest point detection
	sift = cv2.xfeatures2d.SIFT_create()

	
	# Iterate through all the training data and append the labels to a list
	trainDataLength = len(glob.glob('trainData/*.jpg'))
	for trainFilename in glob.glob('trainData/*.jpg'):
		trainLabelString = trainFilename.split("/")[1].split("_")[0] # Store the label
		trainLabel = labelToNum[trainLabelString] # Map the label to number [0-2]
		trainImage = cv2.imread(trainFilename); # Read the test image

		# Extract the descriptors for each training image
		keyPoints = sift.detect(trainImage)
		keyPoints, descriptor = sift.compute(trainImage, keyPoints)
		descriptorList.append(descriptor);
		
		labels.append(trainLabel) # append the label

	#convert to numpy array
	labels = np.array(labels)

	# For KMeans => the Input should be of np.float32 data type, and each feature should be put in a single column.
	# so we need to stack each descriptor to vertical coloumn - using vstack of numpy :
	# Stack all the descriptors vertically in a numpy array
	descriptors = descriptorList[0][1]
	for des in descriptorList[1:]:
		descriptors = np.vstack((descriptors, des))  # Stacking the descriptors



   	# pass this to kmeans to cluster
   	# define criteria, number of clusters(K) and apply kmeans()
	criteria = (cv2.TERM_CRITERIA_EPS, 10, 1.0)
	centers, variance = kmeans(descriptors, K, 1)

	# Calculate the histogram of features
	trainFeatures = np.zeros((trainDataLength, K), "float32")
	for i in range(trainDataLength):
		words, distance = vq(descriptorList[i],centers)
		for w in words:
			trainFeatures[i][w] += 1

    
	return trainFeatures, centers, labels

def inference(trainFeatures, centers, labels, testFilename):

	# Read the test image
	testImage = cv2.imread(testFilename)
	newlist = []

	# Extract the descriptors using SIFT for the test image
	sift = cv2.xfeatures2d.SIFT_create()
	keyPoints = sift.detect(testImage)
	keyPoints, descriptor = sift.compute(testImage, keyPoints)
	newlist.append(descriptor);

	descriptors = newlist[0][1]
	for des in newlist[1:]:
		descriptors = np.vstack((descriptors, des))  # Stacking the descriptors


	testFeatures = np.zeros((1, K), "float32")
	for i in range(1):
		words, distance = vq(newlist[i],centers)
		for w in words:
			testFeatures[i][w] += 1  # Calculating the histogram of features


	# Performing K Nearrest Neighbours Classification to predict the output class
	knn = cv2.ml.KNearest_create()
	# Training the KNN using the training data features and labels
	knn.train(trainFeatures, cv2.ml.ROW_SAMPLE, labels) # Calls the inbuilt train function with the training data and labels
	# Running KNN for test image
	ret, results, neighbours ,dist = knn.findNearest(testFeatures, k=17)

	# If class 0 : horse; class 1 : Bike
	if int(ret) == 0:
		prediction = "horse"
	else:
		prediction = "bike"


	return prediction



def main():
	# Initially learn the model
	features, centers, labels = learning()
	accurateCount = 0

	# Then for each test image we run the inference algorithm
	testDataLength = len(glob.glob('testData/*.jpg'))
	print("=========================================================================")
	print("\n{:<20} {:<20} {:<20}".format("Image","Predicted Label","Actual Label"))
	print("=========================================================================")
	for testFilename in glob.glob('testData/*.jpg'):
		testLabelString = testFilename.split("/")[1].split("_")[0] # Store the label
		testLabel = labelToNum[testLabelString] # Map the label to number [0-1]

		# Running inference for the test image
		predictedLabel = inference(features, centers, labels, testFilename)
		print("{:<20} {:<20} {:<20}".format(testFilename.split("/")[1],predictedLabel,testLabelString))

		if(predictedLabel == testLabelString):
			accurateCount = accurateCount + 1

	# Calculating the accuracy of prediction
	accuracy = accurateCount / float(testDataLength) * 100
	print("\nAccuracy : " + str(accuracy))





main()
