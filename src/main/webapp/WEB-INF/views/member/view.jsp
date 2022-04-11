<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title></title>
	<script src="/kopo/js/jquery_3.6.0.js"></script>
	<script src="/kopo/js/article_count.js"></script>
</head>
<body>
	<div id="id" data-board="${boardId}" data-article="${articleId}">
		<div>
			<h3>${item.subject}</h3>
		</div>
		<div>
			<p>${item.contents}</p>
		</div>
		<div>
			<button id="good-btn">좋아요 ${item.goodCount}</button>
			<button id="bad-btn">싫어요 ${item.badCount}</button>
		</div>
	</div>
	<div>
		<a href="../list">뒤로가기</a>
	</div>
</body>
</html>