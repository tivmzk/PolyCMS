<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<h3>회원 목록</h3>
		</div>
		<div>
			<table border='1'>
				<thead>
					<tr>
						<th>아이디</th>
						<th>비밀번호</th>
						<th>성명</th>
						<th>가입일시</th>
						<th>등급</th>
						<th>관리</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${list.size() < 1}">
						<tr>
							<td colspan="6">등록 된 게시판이 없습니다.</td>
						</tr>
					</c:if>
					
					<c:forEach items="${list}" var="item">
						<tr>
							<td>${item.id}</td>
							<td>${item.passwd}</td>
							<td>${item.name}</td>
							<td><fmt:formatDate value="${item.regDate}" pattern="yyyy/MM/dd HH:mm:ss"/></td>
							<td>${item.grade}</td>
							<td>
								<a href="update/${item.id}">수정</a>
								<a href="delete/${item.id}">삭제</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="6">
							<div>
								<div><a href="?page=1">처음</a></div>
								<div><a href="?page=${pager.prev}">이전</a></div>
								
								<c:forEach items="${pager.list}" var="page">
									<div><a href="?page=${page}">${page}</a></div>
								</c:forEach>
								
								<div><a href="?page=${pager.next}">다음</a></div>
								<div><a href="?page=${pager.last}">마지막</a></div>
							</div>
						</td>
					</tr>
				</tfoot>
			</table>
		</div>
		<div>
			<a href="add">추가</a>
		</div>
		<div>
			<a href="dummy">대량 추가</a>
		</div>
		<div>
			<a href="init">초기화</a>
		</div>
	</div>
</body>
</html>