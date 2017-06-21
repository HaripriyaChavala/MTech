import cv2
import numpy as np
from matplotlib import pyplot as plt

#Reading BGR image
img0 = cv2.imread('bird.jpeg')

#Converting to gray scale
gray = cv2.cvtColor(img0, cv2.COLOR_BGR2GRAY)

#Applying Gaussian blur to smoothen the image
img = cv2.GaussianBlur(gray,(3,3),0)

#Applying Laplacian filtering
l = cv2.Laplacian(img,cv2.CV_8U)

#Sharpening image
res=gray+l

#Displaying results
cv2.imshow("laplacian",l)#Edges
cv2.imshow("sharpened image",res)#Sharpened image
cv2.waitKey(0)







