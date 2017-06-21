'''
Run the program as follows : python MeanShift.py <imagefilename>
'''
import numpy as np
from sklearn.cluster import MeanShift, estimate_bandwidth
import cv2
import sys

# Read the input image and the number of clusters from the command line
inputFile = sys.argv[1]
img = cv2.imread(inputFile)
 
# Reshaping the image before performing the segemntation
flatImage = img.reshape((-1,3))
flatImage = np.float32(flatImage)
 
# Estimating bandwidth - the radius of influence of each data point.
bandwidth = estimate_bandwidth(flatImage, quantile=.2, n_samples=500)
ms = MeanShift(bandwidth, bin_seeding=True)
# Perform clustering
ms.fit(flatImage)

# Obtaining the labels and cluster centers of Mean Shift clustering
labels = ms.labels_
centers = ms.cluster_centers_

# Finding the number of clusters
clusters = labels.max()+1
print("Number of clusters : " ,clusters);

# Reconstructing the segmented image
centers = np.uint8(centers)
output = centers[labels]
output = output.reshape((img.shape))

# Displaying the image
cv2.imshow("output",output)
cv2.waitKey(0)
cv2.destroyAllWindows()