<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <%
    	String sessionId=(String) session.getAttribute("sessionId");
    %>
<nav class="navbar navbar-expand navbar-dark bg-dark">		<!-- 메뉴표시줄 생성 부트스트랩 CSS -->
<div class="container">
<div class="navbar-header">
<a class="navbar-brand" href="./welcome.jsp">Home</a>	<!-- 메뉴표시줄 생성부트스트랩 CSS -->
</div>
<div>
	<ul class="navbar-nav mr-auto">
	<c:choose>
		<c:when test="${empty sessionId}">
						<li class="nav-item"><a class="nav-link" href='<c:url value="./loginMember.jsp"/>'>로그인 </a></li>
						<li class="nav-item"><a class="nav-link" href='<c:url value="./addMember.jsp"/>'>회원 가입</a></li>
					</c:when>
					<c:otherwise>
						<li style="padding-top: 7px; color: white">[<%=sessionId%>님]</li>
						<li class="nav-item"><a class="nav-link" href="<c:url value="./logoutMember.jsp"/>">로그아웃 </a></li>
						<li class="nav-item"><a class="nav-link" href="<c:url value="./updateMember.jsp"/>">회원 수정</a></li>
					</c:otherwise>
	</c:choose>
		<li class="nav-item"><a class="nav-link" href="./products.jsp">상품 목록</a></li>
		<li class="nav-item"><a class="nav-link" href="./addProduct.jsp">상품 등록</a></li>
		<li class="nav-item"><a class="nav-link" href="./editProduct.jsp?edit=update">상품 수정</a></li>
		<li class="nav-item"><a class="nav-link" href="./editProduct.jsp?edit=delete">상품 삭제</a></li>
		<li class="nav-item"><a class="nav-link" href="<c:url value="./BoardListAction.do?pageNum=1"/>">게시판</a></li>
	</ul>
	</div>
</div>

</nav>
