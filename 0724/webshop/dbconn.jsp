<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
	Connection conn=null;
	try{
		String url="jdbc:mysql://localhost:3306/smartweb";
		String user="root";
		String password="1111";
		
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection(url, user, password);
	}catch(SQLException e){
		out.println("SMARTWEB 데이터베이스에 연결이 실패 했습니다.<br/>");
		out.println("예외 : "+e.getMessage());
	}
%>       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>