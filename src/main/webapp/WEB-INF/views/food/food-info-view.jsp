<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
		<th>번호</th>
		<td data-col=fiNum></td>
	</tr>
	<tr>
		<th>이름</th>
		<td data-col="fiName"></td>
	</tr>
	<tr>
		<th>가격</th>
		<td data-col="fiPrice"></td>
	</tr>
	<tr>
		<th>설명</th>
		<td data-col="fiDesc" data-type="enter"></td>		
	</tr>
	<tr>
		<th>생성일</th>
		<td data-col="credat"></td>		
	</tr>
	<tr>
		<th>active</th>
		<td data-col="active"></td>		
	</tr>
	<tr>
		<th colspan="2"><button onclick="location.href='/views/food/food-info-update?fiNum=${param.fiNum}'">수정</button> <button onclick="doDelete()">삭제</button></th>
	</tr>
	
</table>

<script>

var url = '/food-info?fiNum=${param.fiNum}';
function doDelete(){
	var xhr = new XMLHttpRequest();
	xhr.open('DELETE', url);
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
			console.log(xhr.responseText);
			if(xhr.responseText=='1'){
				alert('삭제 완료');
				location.href='/views/food/food-info-list';
			}else{
				alert('삭제 실패');
			}
		}
	}
	xhr.send();
}
window.onload = function(){
	var xhr = new XMLHttpRequest();
	xhr.open('GET', url);
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
			console.log(xhr.responseText);
			var res = JSON.parse(xhr.responseText);
			var tds = document.querySelectorAll('td[data-col]');
			for(var td of tds){
				var col = td.getAttribute('data-col');
				var type = td.getAttribute('data-type');
				var data = res[col];
				if(type==='enter'){
					data = data.split('\n').join('<br>');
				}
				td.innerHTML = data;
			}
		}
	}
	xhr.send();
}
</script>
</body>
</html>
</body>
</html>