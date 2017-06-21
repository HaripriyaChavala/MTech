import numpy as np
import cv2
from matplotlib import pyplot as plt

image = cv2.imread("ball.jpg"); # Reading color image
img  =cv2.cvtColor(image, cv2.COLOR_BGR2GRAY) #Converting to grayscale
rows, cols = img.shape  # Size of the image

'''
This can be done using an inbuilt function 'equalizeHist'
res = cv2.equalizeHist(img); 
'''

'''
Below is our implemention of the same and we get the same result as the inbuilt function
'''
K = 255
h = [0 for i in range(K)]  
c = [0 for i in range(K)]

# Calculating 'h' : Number of pixels for each gray level value
for i in range(rows):
	for j in range(cols):
		h[img[i][j]] = h[img[i][j]] + 1;

# Calculating the cumulative histogram
c[0] = h[0];
for i in range(1,K):
	c[i] = c[i-1] + h[i]
for i in range(1,K):
	c[i] = c[i]/float(rows*cols)

# Defining result image : res : K * C[img]
size = rows,cols,3
res = np.zeros(size, dtype=np.uint8)
for i in range(rows):
	for j in range(cols):
		res[i][j] = K * c[img[i][j]]

cv2.imwrite('hist_ball.png',res)
cv2.waitKey();
