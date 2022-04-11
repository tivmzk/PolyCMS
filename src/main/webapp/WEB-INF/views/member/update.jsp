<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div>
		<div>
			<h3>회원 수정</h3>
		</div>
		<form method="post">
			<div>
				<label for="">비밀번호</label>
				<input type="password" name="passwd" value="${item.passwd}"/>
			</div>
			<div>
				<label for="">이름</label>
				<input type="text" name="name" value="${item.name}"/>
			</div>
			<div>
				<label for="">등급</label>
				<input type="number" name="grade" value="${item.grade}"/>
			</div>
			<div>
				<label>가입일시</label>
				<p>
					<fmt:formatDate value="${item.regDate}" pattern="yyyy년 MM월 dd일 HH시 mm분 ss초"/>
				</p>
			</div>
			<div>
				<button>수정</button>
				<button type="button">취소</button>
			</div>
		</form>
	</div>
</body>
</html>