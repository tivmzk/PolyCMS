<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div>
		<div>
			<h3>회원 등록</h3>
		</div>
		<form method="post">
			<div>
				<label for="">아이디</label>
				<input type="text" name="id"/>
			</div>
			<div>
				<label for="">비밀번호</label>
				<input type="password" name="passwd"/>
			</div>
			<div>
				<label for="">이름</label>
				<input type="text" name="name"/>
			</div>
			<div>
				<label for="">등급</label>
				<input type="number" name="grade"/>
			</div>
			<div>
				<button>등록</button>
				<button type="button">취소</button>
			</div>
		</form>
	</div>
</body>
</html>