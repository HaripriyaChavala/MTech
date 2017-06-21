import cv2
import numpy as np

#creating a black image
blank_image = np.zeros((500,500,3), np.uint8)

#Creating binary synthetic image
for i in range(100,400):
	#for j in range(50): #To increase the width of the white line
	blank_image[i][250] = (255,255,255)

#Displaying binary synthetic image
cv2.imshow("new",blank_image)

#Edge detection using sobel's vertical and horizontal masks
sobelx = cv2.Sobel(blank_image,cv2.CV_64F,1,0,ksize=5) #vertical
sobely = cv2.Sobel(blank_image,cv2.CV_64F,0,1,ksize=5) #horizontal

#Defining prewitt masks
kernelx = np.array([[1,1,1],[0,0,0],[-1,-1,-1]]) #vertical
kernely=np.array([[1,0,-1],[1,0,-1],[1,0,-1]]) #horizontal

#Convolution using prewitt masks
prewittx = cv2.filter2D(blank_image, cv2.CV_64F, kernelx);
prewitty = cv2.filter2D(blank_image, cv2.CV_64F, kernely);

#Displaying the results
cv2.imshow("prewittx",prewittx)
cv2.imshow("prewitty",prewitty)

cv2.imshow("x",sobelx)
cv2.imshow("y",sobely)

cv2.waitKey(0);
