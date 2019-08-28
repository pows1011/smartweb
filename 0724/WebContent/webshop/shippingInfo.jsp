<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>배송 정보</title>
<link rel="stylesheet" href="../resources/css/bootstrap.min.css"/>
<script type="text/javascript">
	function checkShipping(){
		var name=/^[가-힣]+$/;
		var zipCode=/^[0-9]+$/;
		
		var form=document.Shipping;
		
		var name=form.name.value;
		var zipCode=form.zipCode.value;
		
 		if(form.name.value =="") {
			alert("이름을 입력해 주세요");
			form.name.select();
			form.name.focus();
			return false;
		}
 		//if(!name.check(name)){
		//	alert("이름은 한글만 입력해주세요!");
		//	form.name.select();
		//	form.name.focus();
		//	return;
		//}
		if(form.shippingDate.value =="") {
			alert("배송일를 입력해 주세요");
			form.shippingDate.select();
			form.shippingDate.focus();
			return false;
		}
		
		if(form.country.value =="") {
			alert("국가를 입력해 주세요");
			form.country.select();
			form.country.focus();
			return false;
		}
		if(form.zipCode.value =="") {
			alert("우편번호를 입력해 주세요");
			form.zipCode.select();
			form.zipCode.focus();
			return false;
		}
		//if(!check(zipCode)){
			//alert("우편번호는 숫자만 입력해주세요!")
			//form.passwd.select();
			//form.passwd.focus();
			//return;
		//}
		if(form.zipCode.value.length <5 || form.zipCode.value.length>5) {
			alert("우편번호는 5글자입니다.");
			form.zipCode.select();
			form.zipCode.focus();
			return false;
		}
		if(form.addressName.value =="") {
			alert("주소를 입력해 주세요");
			form.addressName.select();
			form.addressName.focus();
			return false;
		}
		form.submit();
		}
</script>
</head>
<body>
	<jsp:include page="header.jsp" />
		<div class="jumbotron">
			<div class="container">
				<h1 class="display-3">배송 정보</h1>
			</div>
		</div>
		
		<div class="container">
			<form action="./processShippingInfo.jsp" class="form-horizontal" method="post"name=Shipping>
				<input type="hidden" name="cartId" value="<%=request.getParameter("cartId") %>"/>
				<div class="form-group row">
					<label class="col-sm-2">성명</label>
					<div class="col-sm-3">
					<input name="name" type="text" class="form-control"/>
					</div>
				</div>
				
				<div class="form-group row">
					<label class="col-sm-2">배송일</label>
					<div class="col-sm-3">
						<input name="shippingDate" type="text"class="form-control"/>(yyyy/mm/dd)
					</div>
				</div>
				
				<div class="form-group row">
					<label class="col-sm-2"> 국가</label>
					<div class="col-sm-3">
						<input name="country" type="text" class="form-control"/>
					</div>
				</div>
				
				<div class="form-group row">
					<label class="col-sm-2">우편번호 </label>
					<div class="col-sm-3">
						<input name="zipCode" type="text" class="form-control"/>
					</div>
				</div>
				
				<div class="form-group row">
					<label class="col-sm-2">주소</label>
					<div class="col-sm-5">
						<input name="addressName" type="text" class="form-control"/>
					</div>
				</div>
				
				<div class="form-group row">
					<div class="col-sm-offset-2 col-sm-10">
						<a href="./cart.jsp?cartId=<%=request.getParameter("cartId") %>" class="btn btn-secondary" role="button">이전</a>
						<input type="button" value="등록" onclick="checkShipping()"class="btn btn-primary"/>
						<a href="./checkOutCancelled.jsp" class="btn btn-secondary" role="button">취소</a>
					</div>
				
				</div>
			</form>
		
		</div>
</body>
</html>