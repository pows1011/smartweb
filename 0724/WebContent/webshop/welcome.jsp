<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.Date" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Welcome</title>
<link rel="stylesheet" href="../resources/css/bootstrap.min.css">
</head>
<body>
<%@include file="header.jsp" %>		<!-- 페이지를 삽입하는 명령어 = header를 상단에 삽입 -->
<%!
String greeting="웹 쇼핑몰에 오신것을 환영합니다";		//String 문자열 함수에 greeting이라는 변수명으로 글자를저장
String tagline="Welcome to Web Market!"; %>		<!-- 마찬가지  -->
<div class ="jumbotron">			<!--영역을나누는 div의 모서리가 둥근 회색상자로 표시되게함 -->
<div class ="container">			<!-- 박스모양의 특을 만들어줌 부트스트랩CSS -->
<h1 class="display-3">	
<%= greeting %></h1></div></div>
<div class="container">
<div class="text-center">		<!-- 글자 중앙 정렬 -->
<a href="./products.jsp">상품 목록 보기</a>
<h3><%= tagline %></h3>

<% 
response.setIntHeader("Refresh",5);
Date day=new java.util.Date();
String am_pm;
int hour=day.getHours();
int minute=day.getMinutes();
int second=day.getSeconds();
if (hour/12==0){
	am_pm="AM";
}else{
	am_pm="PM";
}
String CT=hour+":"+minute+":"+second+" "+am_pm;
out.println("현재 접속 시각 :"+CT+"\n");
%>
</div></div>
<%@include file="footer.jsp" %>
</body>
</html>