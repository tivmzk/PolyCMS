$(function () {
	ajax_article_count({type:'ref_count'}, function(result){
		console.log('조회수 카운트 성공 : ' + result.count);
	});

	/* 좋아요 버튼 */
	$('#good-btn').click(function () {
		ajax_article_count({type:'good_count'}, function(result){
			$('#good-btn').text('좋아요 ' + result.count);
		});
	});

	/* 싫어요 버튼 */
	$('#bad-btn').click(function () {
		ajax_article_count({type:'bad_count'}, function(result){
			$('#bad-btn').text('싫어요 ' + result.count);
		});
	});
});

function ajax_article_count(item, success){
	$.ajax('', {
		method: 'POST',
		contentType: 'application/json',
		dataType: 'json',
		data: JSON.stringify(item),
		success:success,
		error: function (xhr, status, err) {
			console.log('error ' + xhr.status + " : " + xhr.reponseText);
		}
	});
}