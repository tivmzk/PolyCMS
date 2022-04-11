package kr.ac.kopo.pager;

import kr.ac.kopo.util.Pager;

public class ArticlePager extends Pager{
	private Long boardId;

	public Long getBoardId() {
		return boardId;
	}

	public void setBoardId(Long boardId) {
		this.boardId = boardId;
	}
}
