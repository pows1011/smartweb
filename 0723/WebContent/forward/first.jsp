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
<h3>�� ������ first.jsp�Դϴ�</h3>
<%--<jsp:forward page="/forward/second.jsp"/> --%>
<jsp:include page="/forward/second.jsp">
<jsp:param value="<%=new Date()%>" name="date"/>
</jsp:include>
<p>===first.jsp�� ������===</p>
</body>
</html>