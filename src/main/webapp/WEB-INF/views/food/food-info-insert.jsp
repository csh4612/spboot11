<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<input type="text" id="fiName" placeholder="이름"><br>
<input type="number" id="fiPrice" placeholder="가격"><br>
<input type="text" id="fiType" placeholder="타입"><br>
<textarea id="fiDesc" placeholder="설명"></textarea><br>

<button onclick="doInsert()">음식 등록</button>

<script>
function doInsert(){
	var xhr = new XMLHttpRequest();
	xhr.open('POST','/food-insert');
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
			console.log(xhr.responseText);
			if(xhr.responseText>0){
				alert('등록 성공');
				location.href='/views/food/food-info-list';
			}
		}
	}
	var param = {
			fiName : document.querySelector('#fiName').value,
			fiPrice : document.querySelector('#fiPrice').value,
			fiType : document.querySelector('#fiType').value,
			fiDesc : document.querySelector('#fiDesc').value,
			customerInfo : {
				cuiNum : ${customerInfo.cuiNum}
			}
	};
	xhr.setRequestHeader('Content-Type','application/json;charset=UTF-8');
	xhr.send(JSON.stringify(param));
}
</script>
</body>
</html>