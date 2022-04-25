class DragOrder{
    constructor(selector){
        // draggable 클래스를 쓰면 전부 드래그가 가능하게 된다
        $(selector).children().each((idx, elem)=>{
            $(elem).attr('draggable', 'true');
            $(elem).attr('data-order', idx);
            $(elem).attr('data-origin-order', idx);

            // dragstart
            // 내가 드래그하는 객체
            $(elem).on('dragstart', e => {
                let target = this.changeToOrderable(e.target);
                console.log(`${target.data('order')} : drag start`);
				
                target.addClass('drag-start');
                e.originalEvent.dataTransfer.setData('text/plain', $(e.target).data('order'));
            });

            $(elem).on('dragend', e => {
				let target = this.changeToOrderable(e.target);
                console.log(`${target.data('order')} : drag end`);
                target.removeClass('drag-start');
            });
            
            // dragenter
            // 내가 드래그한 객체가 위
            $(elem).on('dragenter', e => {
				let target = this.changeToOrderable(e.target);
                console.log(`${target.data('order')} : drag enter`);
                target.addClass('drag-over');
            });

            // dragover
            // 내가 드래그한 객체가 위에 계속 있을 때
            $(elem).on('dragover', e => {
                // 버블링 방지
                e.preventDefault();
                let target = this.changeToOrderable(e.target);
                console.log(`${target.data('order')} : drag over`);                    
            });

            // dragleave
            // 내가 드래그한 객체가 위에서 벗아 났을 때
            $(elem).on('dragleave', e => {
				let target = this.changeToOrderable(e.target);
                console.log(`${target.data('order')} : drag leave`);
                target.removeClass('drag-over');
            });

            // drop
            // 내가 드래그한 객체가 위에서 드래그 해제 될 때
            $(elem).on('drop', e => {
                e.preventDefault();
                let target_elem = this.changeToOrderable(e.target);
                target_elem.removeClass('drag-over');
                
                console.log(`${target_elem.data('order')} : drop`);

                const source = e.originalEvent.dataTransfer.getData('text/plain');
                const target = target_elem.data('order');
                console.log(`Move : ${source} --> ${target}`);
                // moveOrder(source, target);

                // drop된 요소의 앞 요소를 찾는다
                const front = target_elem.prev();
                // 드래그 중인 요소를 찾는다
                const draged = $(`[data-order='${source}']`);
                // 드래그 중인 요소의 앞에 드롭한 요소를 옮긴다
                draged.before(target_elem);

                if(front.length !== 0){

                    // 드롭한 요소의 앞에 뭔가 있을 경우 그 뒤에 드래그하는 요소를 옮긴다
                    front.after(draged);
                }
                else{
                    // 드롭한 요소의 앞에 아무것도 없으면 부모 요소의 앞에 놓는다
                    target_elem.parent().prepend(draged);
                }
                
                // data-order의 값을 다시 설정
                $('[data-order]').each((idx, elem) => {
					$(elem).attr('data-order', idx);
				});
            });
        });
    }
    // data-order가 있는 요소 인지 아닌지 확인하는 메서드
    isOrderable(elem){
		if(elem.data('order')){
			return true;
		}
		else{
			return false;
		}
	}
	// 입력한 요소의 주위에 있는 data-order를 가진 요소를 찾아준다
	findOrderable(elem){
		if(!elem.data('order')){
			elem = elem.closest('[data-order]');
		}
		
		return elem;
	}
	
	// 입력한 요소를 data-order를 가진요소로 바꿔준다
	changeToOrderable(elem){
		let target = $(elem);

        if(!this.isOrderable(target)){
			target = this.findOrderable(target);
		}
		
		return target;
	}
}