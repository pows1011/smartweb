<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="webshop.dto.Product" %> 
<%@ page import="webshop.dao.ProductRepository" %>  
<%@ page import="com.oreilly.servlet.*, com.oreilly.servlet.multipart.*, java.util.*" %> 
<%@ page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="dbconn.jsp" %>
	<%
		request.setCharacterEncoding("UTF-8");
	
		String filename="";
		//String realFolder="C:\\bigjava\\eclipse_ee\\eclipse-workspace\\0724\\WebContent\\upload";
		String realFolder="C:\\upload";
		int maxSize=5*1024*1024;
		String encType="utf-8";
		
		MultipartRequest multi=new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
	
		String productId=multi.getParameter("productId");
		String name=multi.getParameter("name");
		String unitPrice=multi.getParameter("unitPrice");
		String description=multi.getParameter("description");
		String manufacturer=multi.getParameter("manufacturer");
		String category=multi.getParameter("category");
		String unitsInStock=multi.getParameter("unitsInStock");
		String condition=multi.getParameter("condition");
		
		Integer price;
		
		if(unitPrice.isEmpty()){
			price=0;
		}else{
			price=Integer.valueOf(unitPrice);
		}
		
		long stock;
		
		if(unitsInStock.isEmpty()){
			stock=0;
		}else{
			stock=Long.valueOf(unitsInStock);	
		}
		
		Enumeration files=multi.getFileNames();
		String fname=(String)files.nextElement();
		String fileName=multi.getFilesystemName(fname);
		
		ProductRepository dao=ProductRepository.getInstance();
		
		PreparedStatement pstmt = null;
		/*ResultSet rs=null;*/
		String sql = "INSERT INTO product VALUES(?,?,?,?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, productId);
		pstmt.setString(2, name);
		pstmt.setInt(3, price);
		pstmt.setString(4, description);
		pstmt.setString(5, category);
		pstmt.setString(6, manufacturer);
		pstmt.setLong(7, stock);
		pstmt.setString(8, condition);
		pstmt.setString(9, fileName);
		pstmt.executeUpdate();
			
		/*
		String sql1="SELECT * FROM product";
		pstmt=conn.prepareStatement(sql1);
		rs=pstmt.executeQuery();
		
		
		if(rs.next()){
			String id=rs.getString("p_id");
			String name1=rs.getString("p_name");
			int price1=rs.getInt("p_unitPrice");
			String descript=rs.getString("p_description");
			String manufact=rs.getString("p_manufacturer");
			String category1=rs.getString("p_category");
			long unistock=rs.getLong("p_unitsInStock");
			String condition1=rs.getString("p_condition");
			String file=rs.getString("p_fileName");
			
			Product newProduct=new Product();
			newProduct.setProductId(id);
			newProduct.setPname(name1);
			newProduct.setUnitPrice(price1);
			newProduct.setDescription(descript);
			newProduct.setManufacturer(manufact);
			newProduct.setCategory(category1);
			newProduct.setUnitsInStock(unistock);
			newProduct.setCondition(condition1);
			newProduct.setFilename(file);
			dao.addProduct(newProduct);	
		}
		
		
		if(rs!=null){
			rs.close();
		}
		*/
		if (pstmt != null){
			pstmt.close();
		}
		if (conn != null){
			conn.close();
		}
		
		Product newProduct=new Product();
		newProduct.setProductId(productId);
		newProduct.setPname(name);
		newProduct.setUnitPrice(price);
		newProduct.setDescription(description);
		newProduct.setManufacturer(manufacturer);
		newProduct.setCategory(category);
		newProduct.setUnitsInStock(stock);
		newProduct.setCondition(condition);
		newProduct.setFilename(fileName);
		dao.addProduct(newProduct);	
		
		response.sendRedirect("products.jsp");
	%>
</body>
</html>











