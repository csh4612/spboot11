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
		<thead>
			<tr>
				<th>넘버</th>
				<th>이름</th>
				<th>가격</th>
				<th>타입</th>
				<th>설명</th>
				<th>생성일</th>
				<th>active</th>				
			</tr>
		</thead>
		<tbody id="tBody">
		</tbody>
	</table>

	<script>
		window.onload = function() {
			var xhr = new XMLHttpRequest();
			xhr.open('GET', '/foods-list');
			xhr.onreadystatechange = function(){
				if(xhr.readyState==4 && xhr.status==200){
					console.log(xhr.responseText);
					var res= JSON.parse(xhr.responseText);
					var html='';
					for(var food of res){
						html += '<tr onclick="location.href=\'/views/food/food-info-view?fiNum=' + food.fiNum + '\'" style="cursor:pointer">';
						html += '<td>' + food.fiNum + '</td>';
						html += '<td>' + food.fiName + '</td>';
						html += '<td>' + food.fiPrice + '</td>';
						html += '<td>' + food.fiType + '</td>';
						html += '<td>' + food.fiDesc + '</td>';
						html += '<td>' + food.credat + '</td>';
						html += '<td>' + food.active + '</td>';
						html += '</tr>'
					}
				}
				document.querySelector('#tBody').innerHTML = html;
			}
			xhr.send();
		}
	</script>
</body>
</html>