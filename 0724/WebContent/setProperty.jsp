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
	<jsp:setProperty property="id" name="person" value="99999999"/>
	<jsp:setProperty property="name" name="person" value="박길동"/>
	<p>아이디:<%=person.getId() %></p>
	<p>이름:<%=person.getName() %></p>
	

</body>
</html>