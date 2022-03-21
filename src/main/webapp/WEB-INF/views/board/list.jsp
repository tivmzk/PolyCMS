<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div>
		<div>
			<h3>게시판 목록</h3>
		</div>
		<div>
			<table border='1'>
				<thead>
					<tr>
						<th>게시판 번호</th>
						<th>게시판명</th>
						<th>댓글</th>
						<th>첨부파일</th>
						<th>공개</th>
						<th>권한</th>
						<th>관리</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${list.size() < 1}">
						<tr>
							<td colspan="7">등록 된 게시판이 없습니다.</td>
						</tr>
					</c:if>
					
					<c:forEach items="${list}" var="item">
						<tr>
							<td>${item.boardId}</td>
							<td>${item.subject}</td>
							<td>${item.reply}</td>
							<td>${item.attach}</td>
							<td>${item.secret}</td>
							<td>${item.permission}</td>
							<td>
								<a href="update/${item.boardId}">수정</a>
								<a href="delete/${item.boardId}">삭제</a>
								<a href="${item.boardId}/article/list">게시글</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div>
			<a href="add">추가</a>
		</div>
	</div>
</body>
</html>