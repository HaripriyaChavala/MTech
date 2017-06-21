<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="f1" action="webapi/start/createasset" method="post">
<input type="hidden" name="stationId" value="0"/>
Test Request Id  <input type="text" name="reqId"/><br/><br/>
 User Id  <select name="userId">
  <option value="1">1</option>
  <option value="2">2</option>
  <option value="3">3</option>
  <option value="4">4</option>
</select><br/><br/>
 Asset Type  <select name="assetType">
  <option value="Block">Block</option>
  <option value="Tissue">Tissue</option>
 </select><br/><br/>
 <input type="submit" value="createAsset"/><br/>



</form>
</body>
</html>