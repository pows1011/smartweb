<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DELETE</title>
</head>
<body>
	<h2>DELETE</h2>
	<form action="delete_process.jsp" method="post">
		<p>아이디 : <input type="text" name="id"/>
		<p>비밀번호 : <input type="password" name="passwd"/>
		<p><input type="submit" value="보내기"/>
	</form>
</body>
</html>