<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList, webshop.dto.Product , webshop.dao.ProductRepository" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니 수정</title>
</head>
<body>
	<%
		String id=request.getParameter("id");
		if(id == null || id.trim().equals("")){
			response.sendRedirect("products.jsp");
			return;
		}
		ProductRepository dao= ProductRepository.getInstance();
		
		Product product =dao.getProductById(id);
		if(product == null){
			response.sendRedirect("exceptionNoProductId.jsp");
		}
		ArrayList<Product> cartList=(ArrayList<Product>)session.getAttribute("cartlist");
		Product goodsQnt=new Product();
		for(int i=0;i<cartList.size();i++){
			goodsQnt=cartList.get(i);
			if(goodsQnt.getProductId().equals(id)){
				cartList.remove(goodsQnt);
			}
		}
		response.sendRedirect("cart.jsp");
	
	%>
</body>
</html>