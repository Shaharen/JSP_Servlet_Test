<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>빅데이터 과정 회원시스템</h1>
	
	<table border = "1">
		<tr>
			<td><%=session.getAttribute("id") %>님 환영합니다!</td>
		</tr>
		<tr>
		<form action = "Logout">
			<td align = "center"><input type = "submit" value = "로그아웃"></td>
		</form>
		</tr>
	</table>
	
</body>
</html>