import cv2
import numpy as np
import math
from matplotlib import pyplot as plt
import random

'''
Adds salt and pepper noise to the image with a limit. Higher the limit higher the noise.
It random chooses a number and if it falls with that range, it adds a black or white noise. 
'''
def salt_pepper(image):
    rows, cols = image.shape
    noise = np.zeros(image.shape,np.uint8)
    limit = 0.05
    for i in range(rows):
        for j in range(cols):
            rand = random.random()
            if rand < limit:
                noise[i][j] = 0   # If random number is between 0 to 0.05 : Black/Pepper noise
            elif rand > (1-limit):
                noise[i][j] = 255 # If random number is between 0.95 to 1 : White/Salt noise
            else:
                noise[i][j] = image[i][j]
    return noise

image = cv2.imread("coins.jpg"); # Reading color image
img  =cv2.cvtColor(image, cv2.COLOR_BGR2GRAY) # Converting to grayscale

noisy = salt_pepper(img) # Adds salt and pepper noise with a given probability.
cv2.imwrite("coins_noisy.jpg",noisy) # Saving the noisy image

# Blurs an image using the median filter. The number represents the kernel size (array). it must be odd(>1)
median = cv2.medianBlur(noisy,3)
cv2.imwrite("coins_median.jpg",median)
cv2.waitKey();