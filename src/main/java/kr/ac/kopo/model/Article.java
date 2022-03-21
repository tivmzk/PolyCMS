package kr.ac.kopo.model;

import java.util.Date;

public class Article {
	private Long articleId;
	private String subject;
	private String contents;
	private Date regDate;
	private Date editDate;
	private Long viewCount;
	private Long goodCount;
	private Long badCount;
	
	private Long boardId;
	
	public Long getBoardId() {
		return boardId;
	}
	public void setBoardId(Long boardId) {
		this.boardId = boardId;
	}
	public Long getArticleId() {
		return articleId;
	}
	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getEditDate() {
		return editDate;
	}
	public void setEditDate(Date editDate) {
		this.editDate = editDate;
	}
	public Long getViewCount() {
		return viewCount;
	}
	public void setViewCount(Long viewCount) {
		this.viewCount = viewCount;
	}
	public Long getGoodCount() {
		return goodCount;
	}
	public void setGoodCount(Long goodCount) {
		this.goodCount = goodCount;
	}
	public Long getBadCount() {
		return badCount;
	}
	public void setBadCount(Long badCount) {
		this.badCount = badCount;
	}
}
