<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>  
<%
	String edit = request.getParameter("edit");
%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품편집</title>
<link rel="stylesheet" href="../resources/css/bootstrap.min.css" />
	<script type="text/javascript">
		function deleteConfirm(id) {
			if (confirm("해당 상품을 삭제합니다!!") == true){
				location.href = "./deleteProduct.jsp?id=" + id;
			}else{
				return;
			}
				
		}
	</script>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">상품 편집</h1>
		</div>
	</div>
	<div class="container">
		<div class="row" align="center">
			<%@ include file="dbconn.jsp"%>
			<%
				PreparedStatement pstmt = null;	
				ResultSet rs = null;
				
				String sql = "SELECT * FROM product";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
			%>
			<div class="col-md-4">
				<img src="c:/upload/<%=rs.getString("p_fileName")%>" style="width: 100%">
				<h3><%=rs.getString("p_name")%></h3>
				<p><%=rs.getString("p_description")%>
				<p><%=rs.getString("p_UnitPrice")%>원
				<p><%
						if (edit.equals("update")) {
					%>
						<a href="./updateProduct.jsp?id=<%=rs.getString("p_id")%>" class="btn btn-success" role="button"> 수정 &raquo;></a>
					<%
						} else if (edit.equals("delete")) {
					%>
						<a href="#" onclick="deleteConfirm('<%=rs.getString("p_id")%>')" class="btn btn-danger" role="button">삭제 &raquo;></a>
					<%
						}
					%>				
			</div>
			<%
				}
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			%>			
		</div>
		<hr>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>