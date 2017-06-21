import cv2
import numpy as np
import math
from matplotlib import pyplot as plt

image = cv2.imread("ball.jpg") # Reading a color image
img=cv2.cvtColor(image, cv2.COLOR_BGR2GRAY) # Converting it to grayscale

mean = np.mean(img) # Mean of image 'img'
var = np.var(img) # Variance of image 'img'
stddev = math.sqrt(var) # Calculating the standard deviation

rows, cols = img.shape;
size = rows,cols, 3
res = np.zeros(size, dtype=np.uint8)
res = (img-mean)/stddev + img # Applying Whitening formula

white = cv2.normalize(res,0,255,cv2.NORM_MINMAX) # Normalizing the values
cv2.imshow("white",white) # Displaying the result
white = white * 255.0; 
cv2.imwrite("ball_white.jpg", white) # Saving the result image
cv2.waitKey(0)

