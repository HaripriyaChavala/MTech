import cv2
#Reading a BGR image
img = cv2.imread("cake.jpg")

#Conversion from BGR to gray image 
#Expression used for conversion : gray = 0.30*red+0.59*green+0.11*blue
gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY) 

#Displaying gray scale image
cv2.imshow("opencv",gray)

#Storing gray scale image
cv2.imwrite("cake_gray1.png",gray);

cv2.waitKey(0)



