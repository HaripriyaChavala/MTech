import numpy as np
import pywt
import cv2
import matplotlib.pyplot as plt
from sklearn import svm
from os import listdir
from os.path import isfile, join

def w2d(imArray, mode='haar', level=1):
    #imArray = cv2.imread(img)
    #Datatype conversions
    #convert to grayscale
    imArray = cv2.cvtColor(imArray,cv2.COLOR_BGR2GRAY )
    ret2,th2 = cv2.threshold(imArray,0,255,cv2.THRESH_BINARY+cv2.THRESH_OTSU)
    edges = cv2.Canny(th2,100,200)
    kernel = np.ones((3,3),np.uint8)
    img_dilation = cv2.dilate(edges, kernel, iterations=1)
    #convert to float
    imArray =  np.float32(img_dilation)   
    imArray /= 255;
    # compute coefficients 
    coeffs=pywt.wavedec2(imArray, mode, level=level)
##    arr = pywt.waverec2(coeffs, 'db1')
    arr, coeff_slices = pywt.coeffs_to_array(coeffs)

    #Process Coefficients
    coeffs_H=list(coeffs)
    coeffs_H[0] *= 0;  

    # reconstruction
    imArray_H=pywt.waverec2(coeffs_H, mode);
    imArray_H *= 255;
    imArray_H =  np.uint8(imArray_H)
    #Display result
##    cv2.imshow('image',imArray_H)
##    cv2.waitKey(0)
##    cv2.destroyAllWindows()
    return arr

mypath='Training/Normal'
onlyfiles = [ f for f in listdir(mypath) if isfile(join(mypath,f)) ]
trainData = []
labels = []
predict_label = [[0 for i in range(100)] for j in range(100)]
mul_fact = [0,0.33,0.66,1]
for i in range(0,3):
	print i
	for n in range(0, len(onlyfiles)):
	    parameters = []
	    path = join(mypath,onlyfiles[n])
	    #print path
	    img = cv2.imread(path);
	    height,width,dim = img.shape
	    h1 = int(mul_fact[i]*height)
	    h2 = int(mul_fact[i+1]*height)
	    crop_img = img[h1:h2, 0:width]
	    arr = w2d(crop_img,'db1',5)
	    parameters.append(np.mean(arr))
	    parameters.append(np.median(arr))
	    parameters.append(np.amax(arr))
	    parameters.append(np.amin(arr))
	    parameters.append(np.ptp(arr))
	    parameters.append(np.std(arr))
	    parameters.append(np.var(arr))
	    trainData.append(parameters)
	    labels.append(0)

	mypath='Training/MI'
	onlyfiles = [ f for f in listdir(mypath) if isfile(join(mypath,f)) ]
	for n in range(0, len(onlyfiles)):
	    path = join(mypath,onlyfiles[n])
	    img = cv2.imread(path);
	    height,width,dim = img.shape
	    h1 = int(mul_fact[i]*height)
	    h2 = int(mul_fact[i+1]*height)
	    crop_img = img[h1:h2, 0:width]
	    arr = w2d(crop_img,'db1',5)
	    parameters = []
	    parameters.append(np.mean(arr))
	    parameters.append(np.median(arr))
	    parameters.append(np.amax(arr))
	    parameters.append(np.amin(arr))
	    parameters.append(np.ptp(arr))
	    parameters.append(np.std(arr))
	    parameters.append(np.var(arr))
	    trainData.append(parameters)
	    labels.append(1)

	clf = svm.SVC(kernel='rbf')
	clf.fit(trainData, labels)

	mypath='Testing/MI'
	onlyfiles = [ f for f in listdir(mypath) if isfile(join(mypath,f)) ]
	count = 0
	correctCount  = 0
	for n in range(0, len(onlyfiles)):
	    parameters = []
	    path = join(mypath,onlyfiles[n])
	    img = cv2.imread(path)
	    height,width,dim = img.shape
	    h1 = int(mul_fact[i]*height)
	    h2 = int(mul_fact[i+1]*height)
	    crop_img = img[h1:h2, 0:width]
	    arr = w2d(crop_img,'db1',5)
	    parameters.append(np.mean(arr))
	    parameters.append(np.median(arr))
	    parameters.append(np.amax(arr))
	    parameters.append(np.amin(arr))
	    parameters.append(np.ptp(arr))
	    parameters.append(np.std(arr))
	    parameters.append(np.var(arr))
	    predict = clf.predict([parameters])
	    count = count + 1
            predict_label[i][n]=predict
	    print i,n,predict_label[i][n],predict
	    #if predict == 0:
		#correctCount = correctCount + 1
	print "------------------------------------------------------------------------------------"
print "------------------------------------------------------------------------------------"

for j in range(0,20):
	print predict_label[0][j],predict_label[1][j],predict_label[2][j];





#print count,correctCount

