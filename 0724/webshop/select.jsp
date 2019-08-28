<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Select member</title>
</head>
<body>
	<h3>select member</h3>
	<%@ include file="dbconn.jsp" %>
	<table width="300" border="1">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
		</tr>
		
		<%
			ResultSet rs=null;
			PreparedStatement pstmt=null;
			
			try{
				String sql="SELECT * FROM member";
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				
				while(rs.next()){
					String id=rs.getString("id");
					String pw=rs.getString("passwd");
					String name=rs.getString("name");
		%>
		
		<tr>
			<td><%=id %></td>
			<td><%=pw %></td>
			<td><%=name %></td>
		</tr>
		
		<%
				}
			}catch(SQLException e){
				out.println("member 테이블 검색이 성공했습니다.<br/>");
				out.println("예외 : "+e.getMessage());
			}finally{
				if(rs!=null){
					rs.close();
				}
				if(pstmt!=null){
					pstmt.close();
				}
				if(conn!=null){
					conn.close();
				}
			}
		%>
	</table>
	
</body>
</html>