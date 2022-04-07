package kr.ac.kopo.service;

import java.util.List;

import kr.ac.kopo.model.Article;
import kr.ac.kopo.model.ArticleCount;
import kr.ac.kopo.util.Pager;

public interface ArticleService {

	List<Article> list(Long boardId, Pager pager);

	void add(Article item);

	Article item(Long boardId, Long articleId);

	void update(Article item);

	void delete(Long boardId, Long articleId);

	void counting(Long boardId, Long articleId, Long count, String countColumn);

	void updateCount(ArticleCount item);

	void dummy(Long boardId);

	void init(Long boardId);

}
