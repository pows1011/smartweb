<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Action Tag</title>
</head>
<body>
<h3>이 파일은 first.jsp입니다</h3>
<%--<jsp:forward page="/forward/second.jsp"/> --%>
<jsp:include page="/forward/second.jsp">
<jsp:param value="<%=new Date()%>" name="date"/>
</jsp:include>
<p>===first.jsp의 페이지===</p>
</body>
</html>