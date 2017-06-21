import cv2
import numpy as np
import math
import glob

''' This function accepts an input image and constructs a color histogram 
    to characterize the color distribution of the image.
'''
def histogram(image, bins=(8, 8, 8)):
	''' extract a 3D color histogram from the HSV color space using
	    8 bins per channel '''
	hsv = cv2.cvtColor(image, cv2.COLOR_BGR2HSV) # Convert the image to HSV
	channel = [0, 1, 2] # To consider all 3 RGB channels
	mask = None # None - Consider the full image
	ranges = [0, 256, 0, 256, 0, 256] # Ranges for each channel
	hist = cv2.calcHist([hsv], channel, mask, bins,
		ranges)
 
 	#normalize the histogram
	hist = cv2.normalize(hist)
	# return the flattened histogram as the feature vector
	return hist.flatten()

def main():

	# Defining the mapping between label and mode
	numToLabel = { 0 : "night", 1 : "landscape" , 2 : "portrait"}
	labelToNum = { "night" : 0, "landscape" : 1 , "portrait" : 2}

	print("=========================================================================")
	print("\n{:<20} {:<20} {:<20}".format("Image","Predicted Label","Actual Label"))
	print("=========================================================================")
	accurateCount = 0
	testDataCount = 0

	# Read all test data images one at a time
	for testFilename in glob.glob('testingData/*.jpg'):

		testDataCount = testDataCount + 1
		testImage = cv2.imread(testFilename)
		testLabelString = testFilename.split("/")[1].split("_")[0] # Store the label
		testHist = histogram(testImage) # Transform and flatten the image 
		testArray = np.array(testHist)
		testArray = testArray
		testData = []
		testData.append(testArray)

		trainData = []
		label = []
		# Iterate through all the training data and append them to a list
		for trainFilename in glob.glob('trainingData/*.jpg'):
			trainLabelString = trainFilename.split("/")[1].split("_")[0] # Store the label

			trainLabel = labelToNum[trainLabelString] # Map the label to number [0-2]
			trainImage = cv2.imread(trainFilename); # Read the test image
			trainHist = histogram(trainImage) # Transform and flatten the image 
			trainArray = np.array(trainHist)
			trainData.append(trainArray) #append the image
			label.append(trainLabel) #append the label

		#convert to numpy array
		trainData = np.array(trainData)
		testData = np.array(testData)
		label = np.array(label)

		knn = cv2.KNearest()
		knn.train(trainData,label) # Calls the inbuilt train function with the training data and labels
		k = 5 # K nearest nieghbors will be considered
		ret, results, neighbours ,dist = knn.find_nearest(testData, k) #Returns the result of K neighbours and the predicted label
		ret = int(ret)
		predictedLabel = numToLabel[ret] #Reverse mapping to a label

		print("{:<20} {:<20} {:<20}".format(testFilename.split("/")[1],predictedLabel,testLabelString))

		# If predicted correctly increment the count
		if(predictedLabel == testLabelString):
			accurateCount = accurateCount + 1

	# Calculating the accuracy of prediction
	accuracy = accurateCount / float(testDataCount) * 100
	print("\nAccuracy : " + str(accuracy))


main()