<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<div>
			<h3>게시판 등록</h3>
		</div>
		<form method="post">
			<div>
				<label for="">게시판명</label>
				<input type="text" name="subject"/>
			</div>
			<div>
				<label>댓글 허용</label>
				<select name="reply">
					<option value="0">댓글 불가</option>
					<option value="1">댓글 허용</option>
				</select>
			</div>
			<div>
				<label>첨부파일 허용</label>
				<select name="attach">
					<option value="0">첨부파일 불가</option>
					<option value="1">단일파일 첨부</option>
					<option value="2">다중파일 첨부</option>
				</select>
			</div>
			<div>
				<label>공개여부</label>
				<select name="secret">
					<option value="0">비공개</option>
					<option value="1">공개</option>
				</select>
			</div>
			<div>
				<label>권한</label>
				<select name="permission">
					<option value="0">쓰기 불가</option>
					<option value="1">쓰기 허용</option>
				</select>
			</div>
			<div>
				<button>등록</button>
				<button type="button">취소</button>
			</div>
		</form>
	</div>
</body>
</html>