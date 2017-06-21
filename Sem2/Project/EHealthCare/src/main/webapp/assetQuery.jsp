<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="assetquery" id="assetquery" action="webapi/assetservice/assetdetails${myid}" method="get">
Asset id <input type="text" name="assetId" id="myid" /><br/>
<input type="submit" value="Get Details"/> 

</form>
</body>
</html>