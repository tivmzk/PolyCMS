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
			<h3>게시글 수정</h3>
		</div>
		<form method="post">
			<div>
				<label for="">제목</label>
				<input type="text" name="subject" value="${item.subject}"/>
			</div>
			<div>
				<label for="">내용</label>
				<textarea name="contents">${item.contents}</textarea>
			</div>
			<div>
				<button>확인</button>
				<button type="button">취소</button>
			</div>
		</form>
	</div>
</body>
</html>