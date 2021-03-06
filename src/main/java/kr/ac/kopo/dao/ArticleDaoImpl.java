package kr.ac.kopo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.model.Article;
import kr.ac.kopo.model.ArticleCount;
import kr.ac.kopo.pager.ArticlePager;

@Repository
public class ArticleDaoImpl implements ArticleDao {
	@Autowired
	SqlSession sql;
	final String NAMESPACE = "article.";
	
	@Override
	public List<Article> list(ArticlePager pager) {
		return sql.selectList(NAMESPACE+"list", pager);
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
	public void counting(Long boardId, Long articleId, Long count, String countColumn) {
		Map<String, Object> map = new HashMap<>();
		map.put("boardId", boardId);
		map.put("articleId", articleId);
		map.put("count", count);
		map.put("countColumn", countColumn);
		sql.update(NAMESPACE+"counting", map);
	}

	@Override
	public void refCount(ArticleCount item) {
		sql.update(NAMESPACE+"ref_count", item);
	}

	@Override
	public void goodCount(ArticleCount item) {
		sql.update(NAMESPACE+"good_count", item);
	}

	@Override
	public void badCount(ArticleCount item) {
		sql.update(NAMESPACE+"bad_count", item);
	}

	@Override
	public long total(ArticlePager pager) {
		return sql.selectOne(NAMESPACE+"total", pager);
	}
}
