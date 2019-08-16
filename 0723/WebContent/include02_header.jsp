<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Directive Tag</title>
</head>
<body>
<%! int pageCount=0;
void addCount(){
pageCount++;}%>
<% addCount(); %>
<p> 이 사이트 방문은 <%=pageCount %>번째입니다</p>
</body>
</html>