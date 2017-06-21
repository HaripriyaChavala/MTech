import cv2
import matplotlib.pyplot as plt
import matplotlib.image as mpimg

img = cv2.imread("bird.jpg"); # reading the image (BGR)
blue,green,red = cv2.split(img)  # Divides a multi-channel array into several single-channel arrays.
cv2.imwrite("blue_bird1.png",blue); # saving the blue channel
cv2.imwrite("green_bird1.png",green); # saving the green channel
cv2.imwrite("red_bird1.png",red); # saving red channel
