package kr.ac.kopo.dao;

import java.util.List;

import kr.ac.kopo.model.Article;
import kr.ac.kopo.model.ArticleCount;
import kr.ac.kopo.util.Pager;

public interface ArticleDao {

	List<Article> list(Long boardId, Pager pager);

	void add(Article item);

	Article item(Long boardId, Long articleId);

	void update(Article item);

	void delete(Long boardId, Long articleId);

	void counting(Long boardId, Long articleId, Long count, String countColumn);

	void refCount(ArticleCount item);

	void goodCount(ArticleCount item);

	void badCount(ArticleCount item);

	long total(Long boardId, Pager pager);

}
