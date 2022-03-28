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
	
	<!-- <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script> -->
	<!-- <script>
		const id = $('#id');
		const item = {
				boardId:id.data('board'),
				articleId:id.data('article')
		};
		/* 조회수 올리기 */
		$.ajax('/kopo/rest/article/view', {
			method:'PUT',
			contentType:'application/json',
			dataType:'json',
			data:JSON.stringify(item),
			success:function(result){
				console.log("조회수 : "+result.viewCount);
			},
			error:function(xhr, status, err){
				console.log('error ' + xhr.status + " : " + xhr.reponseText);
			}
		});
		/* 좋아요 버튼 */
		$('#good-btn').click(function(){
			$.ajax('/kopo/rest/article/good', {
				method:'PUT',
				contentType:'application/json',
				dataType:'json',
				data:JSON.stringify(item),
				success:function(result){
					$('#good-btn').text('좋아요 ' + result.goodCount);
				},
				error:function(xhr, status, err){
					console.log('error ' + xhr.status + " : " + xhr.reponseText);
				}
			});
		});
		/* 싫어요 버튼 */
		$('#bad-btn').click(function(){
			$.ajax('/kopo/rest/article/bad', {
				method:'put',
				contentType:'application/json',
				dataType:'json',
				data:JSON.stringify(item),
				success:function(result){
					$('#bad-btn').text('싫어요 ' + result.badCount);
				},
				error:function(xhr, status, err){
					console.log('error ' + xhr.status + " : " + xhr.reponseText);
				}
			});
		});
	</script> -->
</body>
</html>