import cv2

img = cv2.imread("pencil.jpg") # Reading a BGR image

#cvtColor funtion - converts an image from one color space to another.
lab = cv2.cvtColor(img, cv2.COLOR_BGR2LAB) # Converting BGR image L*a*b*
l, a, b = cv2.split(lab)  
cv2.imshow("lab",lab) # to display the result
cv2.imwrite("pencil_lab.png",lab); # saving the result

cv2.waitKey(0) # to exit the program on any key press

