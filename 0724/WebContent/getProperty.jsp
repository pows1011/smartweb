<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Action Tag</title>
</head>
<body>
	<jsp:useBean id="person" class="webshop.Person" scope="request"/>
	<p>아이디:<jsp:getProperty name="person" property="id" /></p>
	<p>이름:<jsp:getProperty name="person" property="name" /></p>
	
</body>
</html>