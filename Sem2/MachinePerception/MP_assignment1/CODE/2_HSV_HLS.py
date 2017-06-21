import cv2
#Reading a BGR image
img = cv2.imread("pencil.jpg")

#Conversion from BGR to HLS
hls = cv2.cvtColor(img, cv2.COLOR_BGR2HLS) # HLS

#Splitting Hue,Saturation and Luminosity channels from HLS image
h,l,s=cv2.split(hls);

#Storing Hue,Sturation and Luminosity channels
cv2.imwrite("hue_pencil.png",h)#Hue channel
cv2.imwrite("light_pencil.png",l)#Luminosity channel
cv2.imwrite("sat_pencil.png",s)#Saturation channel

#Conversion from BGR to HSV
hsv = cv2.cvtColor(img, cv2.COLOR_BGR2HSV) # HSV 

#Splitting Hue,Saturation and Value channels from HSV image
h1,s1,v1=cv2.split(hsv);

#Storing Hue,Sturation and Value channels
cv2.imwrite("hue_pencil1.png",h1)#Hue channel
cv2.imwrite("sat_pencil1.png",s1)#Saturation channel
cv2.imwrite("val_pencil1.png",v1)#Value channel

#Displaying HSV and HLS images
cv2.imshow("opencv",hls)
cv2.imshow("opencv",hsv)

#Storing HSV and HLS images
cv2.imwrite("pencil_hsl.png",hls); 
cv2.imwrite("pencil_hsv.png",hsv);

cv2.waitKey(0)



