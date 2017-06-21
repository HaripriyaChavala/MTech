import cv2
import numpy as np

image = np.zeros((500,500), np.uint8) # Creating a black image of 500X500
for i in range(100,400): # Drawing 2 45 degree strips
	image[i][500-i] = 255 # White line
	image[i][i] = 255
cv2.imshow("45 degree",image)

kernel1 = np.array([[1,0],[0,-1]]) # Robert's mask Gx orientation
kernel2 = np.array([[0,-1],[1,0]]) # Robert's mask Gy orientation
dst = cv2.filter2D(image, cv2.CV_64F, kernel1); # Convoluting Robert's mask (kernel1) on the image
cv2.imshow("Robert1",dst)
dst = cv2.filter2D(image, cv2.CV_64F, kernel2); # Convoluting Robert's mask (kernel2) on the image
cv2.imshow("Robert2",dst)
cv2.waitKey(0);