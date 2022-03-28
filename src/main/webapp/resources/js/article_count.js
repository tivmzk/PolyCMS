$(function () {
	const item = {
		type: "ref_count"
	};

	$.ajax("", {
		method: 'POST',
		contentType: 'application/json',
		dataType: 'json',
		data: JSON.stringify(item),
		success: function (result) {
			console.log("조회수 설정 성공");
		},
		error: function (xhr, status, err) {
			console.log('error ' + xhr.status + " : " + xhr.reponseText);
		}
	});

	/* 좋아요 버튼 */
	$('#good-btn').click(function () {
		item.type = 'good_count';
		$.ajax('', {
			method: 'POST',
			contentType: 'application/json',
			dataType: 'json',
			data: JSON.stringify(item),
			success: function (result) {
				$('#good-btn').text('좋아요 ' + result.count);
			},
			error: function (xhr, status, err) {
				console.log('error ' + xhr.status + " : " + xhr.reponseText);
			}
		});
	});
	/* 싫어요 버튼 */
	$('#bad-btn').click(function () {
		item.type = 'bad_count';
		$.ajax('', {
			method: 'POST',
			contentType: 'application/json',
			dataType: 'json',
			data: JSON.stringify(item),
			success: function (result) {
				$('#bad-btn').text('싫어요 ' + result.count);
			},
			error: function (xhr, status, err) {
				console.log('error ' + xhr.status + " : " + xhr.reponseText);
			}
		});
	});
});