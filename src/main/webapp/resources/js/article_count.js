$(function(){
	const item = {
			type:"ref_count"
	};
	
	$.ajax("", {
		method:'POST',
		contentType:'application/json',
		dataType:'json',
		data:JSON.stringify(item),
		success:function(result){
			console.log("조회수 설정 성공");
		},
		error:function(xhr, status, err){
			console.log('error ' + xhr.status + " : " + xhr.reponseText);
		}
	});
});