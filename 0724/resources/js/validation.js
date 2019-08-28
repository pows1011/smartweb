/**
 * 제품등록화면 유효성 체크 코드
 */

function CheckAddProduct(){
	
	var productId=document.getElementById("productId");
	var name=document.getElementById("name");
	var unitPrice=document.getElementById("unitPrice");
	var unitsInStock=document.getElementById("unitsInStock");
	
	if(!check(/^P[0-9]{4,11}$/, productId, "[상품 코드]\nP와 숫자를 조합하여 4~11자까지 입력하세요\n첫 글자는 반드시 P로 시작하세요.")){
		productId.select();
		productId.focus();
		//alert("[상품 코드]\nP와 숫자를 조합하여 4~11자까지 입력하세요\n첫 글자는 반드시 P로 시작하세요.");
		return false;
	}else if(name.value.length<2 || name.value.length>12){
		alert("[상품명]\n최소 2자에서 최대 12자까지 입력하세요.");
		name.select();
		name.focus();
		return false;
	}else if(unitPrice.value.length==0 || isNaN(unitPrice.value)){
		alert("[가격]\n숫자만 입력하세요.");
		unitPrice.select();
		unitPrice.focus();

		if(unitPrice.value < 0){
			alert("[가격]\n음수를 입력할 수 없습니다.");
			unitPrice.select();
			unitPrice.focus();
			return false;
		}else if(!check(/^\d+(?:[.]?[\d]?[\d])?$/, unitPrice, "[가격]\n소수점 둘째 자리까지만 입력하세요.")){
			return false;
		}
		
	}
	
	if(!check(/^[0-9]{1,3}$/, unitsInStock, "[재고 수]\n숫자만 입력하세요.")){
		unitsInStock.select();
		unitsInStock.focus();
		return false;
	}
	
	//alert("unitsInStock : "+unitsInStock);
	
	function check(regExp, e, msg){
		
		if(regExp.test(e.value)){
			return true;
		}
		alert(msg);
		e.select();
		e.focus();
		return false;
	}
	
	document.newProduct.submit();
}