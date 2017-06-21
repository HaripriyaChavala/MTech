'''
Run the program as follows : python Kmeans.py <imagefilename> <numberOfClusters>
'''
import numpy as np
import cv2
import sys

# Read the input image and the number of clusters from the command line
inputFile = sys.argv[1]
K = int(sys.argv[2])
img = cv2.imread(inputFile)

# Reshaping the image for KMeans as it should be of np.float32 data type, and each feature should be put in a single column.
flatImage = img.reshape((-1,3))
flatImage = np.float32(flatImage)

# criteria - It is the iteration termination criteria. =>(type, max_iter, epsilon)
criteria = (cv2.TERM_CRITERIA_EPS, 10, 1.0)
# number of times the algorithm is executed using different initial labellings
attempts = 10
# Run KMeans - Initially start with random centers
ret,label,center=cv2.kmeans(flatImage,K,None,criteria,attempts,cv2.KMEANS_RANDOM_CENTERS)

# Reconstructing the segmented image
center = np.uint8(center)
output = center[label.flatten()]
output = output.reshape((img.shape))

# Displaying the image
cv2.imshow('Segmented Image',output)
cv2.waitKey(0)
cv2.destroyAllWindows()