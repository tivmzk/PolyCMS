package kr.ac.kopo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.model.Article;

@Repository
public class ArticleDaoImpl implements ArticleDao {
	@Autowired
	SqlSession sql;
	final String NAMESPACE = "article.";
	
	@Override
	public List<Article> list(Long boardId) {
		return sql.selectList(NAMESPACE+"list", boardId);
	}

	@Override
	public void add(Article item) {
		sql.insert(NAMESPACE+"add", item);
	}

	@Override
	public Article item(Long boardId, Long articleId) {
		Map<String, Object> map = new HashMap<>();
		map.put("boardId", boardId);
		map.put("articleId", articleId);
		return sql.selectOne(NAMESPACE+"item", map);
	}

	@Override
	public void update(Article item) {
		sql.update(NAMESPACE+"update", item);
	}

	@Override
	public void delete(Long boardId, Long articleId) {
		Map<String, Object> map = new HashMap<>();
		map.put("boardId", boardId);
		map.put("articleId", articleId);
		sql.delete(NAMESPACE+"delete", map);
	}

	@Override
	public void viewCounting(Long boardId, Long articleId, Long viewCount) {
		Map<String, Object> map = new HashMap<>();
		map.put("boardId", boardId);
		map.put("articleId", articleId);
		map.put("viewCount", viewCount);
		sql.update(NAMESPACE+"viewCounting", map);
	}
}
