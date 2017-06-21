import cv2
import numpy as np
import math
from matplotlib import pyplot as plt

#Reading a BGR image
img = cv2.imread("numbers.jpg")

#Smoothing image with Gaussian mask at different scales
res3 = cv2.GaussianBlur( img, (3,3), 0) #scale 3
res5 = cv2.GaussianBlur( img, (5,5), 0) #scale 7
res7 = cv2.GaussianBlur( img, (7,7), 0) #scale 11

#Displaying blurred images
cv2.imshow("res3",res3) #scale 3
cv2.imshow("res5",res5) #scale 7
cv2.imshow("res7",res7) #scale 11

cv2.waitKey(0);


''' As we increase the scale, noise is reduced and also there is a degrade in the quality of image'''
