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
	<p><%=person.getId() %></p>
	<p><%=person.getName() %></p>
	
<%
	person.setId(12345678);
	person.setName("�̼���");
%>
<jsp:include page="useBean.jsp"/> <%-- ȣ���ؿ��°�--%>
</body>
</html>