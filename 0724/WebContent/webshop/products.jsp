<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList, webshop.dto.Product" %> 
<%@ page import="webshop.dao.ProductRepository" %> 
<%@ page import="java.sql.*" %>
    <!--<jsp:useBean id="productDAO" class="webshop.dao.ProductRepository" scope="session"/>-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/css/bootstrap.min.css"/>
<title>상품 목록</title>
</head>
<body>
<%@include file="header.jsp" %>
	
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">상품목록</h1>
		</div>
	</div>

	<div class="container">
		<div class="row" align="center">
			<%@ include file="dbconn.jsp" %>
			<%
				PreparedStatement pstmt=null;
				ResultSet rs= null;
				String sql ="select * from product";
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				while(rs.next()){
			
			%>
		<div class="col-md-4">
				<img src="../upload/<%=rs.getString("p_fileName")%>" style="width:100%"/>
				<h3><%=rs.getString("p_name") %></h3>
				<p><%=rs.getString("p_description") %>
				<p><%=rs.getInt("p_unitPrice") %>원
				<p><a href="./product.jsp?id=<%=rs.getString("p_id")%>" class="bin btn-secondary" role="button">상세 정보 &raquo;</a>
		</div>
<%
}
%>
<%			if(rs!=null)
				rs.close();
			if(pstmt !=null)
				pstmt.close();
			if(conn!=null)
				conn.close();
			
%>				
<a href="./addProduct.jsp">상품 등록</a>
</div>
<hr/>
</div>
<jsp:include page="footer.jsp" />
</body>
</html>