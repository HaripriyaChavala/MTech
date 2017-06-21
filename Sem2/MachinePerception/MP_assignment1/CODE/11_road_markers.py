import numpy as np
import cv2

#Reading input image
img = cv2.imread('21road.jpg')

#Converting the input image to gray scale image
gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)


kernel_size = 7 

#Smoothing the image using Gaussian Blur
blur = cv2.GaussianBlur(gray, (kernel_size, kernel_size), 0)

#Finding the edges in the image using Canny edge detector
edge = cv2.Canny(blur, 100, 200, apertureSize=3)  
cv2.imwrite("21road_canny.jpg",edge)

minLineLength = 100 # min length of line, line segments shorter than this are rejected 

maxLineGap = 10 # max allowed gap between line segmnets to treat them as single line 

threshold = 50 # Min No of votes(points on line) for it to be a line

rho = 1 #Distance resolution of the accumulator in pixels

theta = np.pi/180  #Angle resolution of the accumulator in radians

#Finding lines in the image
lines = cv2.HoughLinesP(edge,rho,theta,threshold,minLineLength,maxLineGap)

color = (0,255,0) # the color of the line to be drawn
thickness = 4 # thickness of the line

#Drawing the detected lines on the image
for x1,y1,x2,y2 in lines[0]: #For each line
	cv2.line(img,(x1,y1),(x2,y2),color,thickness)  #x1,y1 and x2,y2 and the 2 points of the line.

cv2.imwrite("21road_hough.jpg",img)

cv2.waitKey(0)
cv2.destroyAllWindows()
