<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DELETE PROCESS</title>
</head>
<body>
	<%@ include file="dbconn.jsp" %>
	<%
		request.setCharacterEncoding("utf-8");
	
		String id=request.getParameter("id");
		String passwd=request.getParameter("passwd");
		String name=request.getParameter("name");
		
		ResultSet rs=null;
		PreparedStatement pstmt=null;
		
		try{
			String sql="SELECT id, passwd FROM member WHERE id= ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				String rid=rs.getString("id");
				String rpasswd=rs.getString("passwd");
				
				if(id.equals(rid)&&passwd.equals(rpasswd)){
					sql="DELETE FROM member WHERE id=? AND passwd=?";		
					pstmt=conn.prepareStatement(sql);
					pstmt.setString(1, id);
					pstmt.setString(2, passwd);
					pstmt.executeUpdate();
					out.println("member 테이블 레코드 값 삭제가 성공했습니다.");
				}else{
					out.println("일치하는 비밀번호가 없습니다.");
				}
			}else{
				out.println("일치하는 아이디가 없습니다.");
			}
			
		}catch(SQLException e){
			out.println("member 테이블 수정이 실패 했습니다.<br/>");
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
</body>
</html>