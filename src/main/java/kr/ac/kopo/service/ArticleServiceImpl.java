package kr.ac.kopo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.dao.ArticleDao;
import kr.ac.kopo.model.Article;
import kr.ac.kopo.model.ArticleCount;

@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	ArticleDao dao;
	
	@Override
	public List<Article> list(Long boardId) {
		return dao.list(boardId);
	}

	@Override
	public void add(Article item) {
		dao.add(item);
	}

	@Override
	public Article item(Long boardId, Long articleId) {
		return dao.item(boardId, articleId);
	}

	@Override
	public void update(Article item) {
		dao.update(item);
	}

	@Override
	public void delete(Long boardId, Long articleId) {
		dao.delete(boardId, articleId);
	}

	@Override
	public void counting(Long boardId, Long articleId, Long count, String countColumn) {
		dao.counting(boardId, articleId, count+1, countColumn);
	}
	
	@Override
	public void updateCount(ArticleCount item) {
		if("ref_count".equals(item.getType())) {
			dao.refCount(item);
			Long count = dao.item(item.getBoardId(), item.getArticleId()).getViewCount();
			item.setCount(count);
		}
		else if("good_count".equals(item.getType())) {
			dao.goodCount(item);
			Long count = dao.item(item.getBoardId(), item.getArticleId()).getGoodCount();
			item.setCount(count);
		}
		else if("bad_count".equals(item.getType())) {
			dao.badCount(item);
			Long count = dao.item(item.getBoardId(), item.getArticleId()).getGoodCount();
			item.setCount(count);
		}
	}
}
