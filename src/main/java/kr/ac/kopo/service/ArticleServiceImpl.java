package kr.ac.kopo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.dao.ArticleDao;
import kr.ac.kopo.model.Article;
import kr.ac.kopo.model.ArticleCount;
import kr.ac.kopo.pager.ArticlePager;

@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	ArticleDao dao;
	
	@Override
	public List<Article> list(ArticlePager pager) {
		long total = dao.total(pager);
		pager.setTotal(total);
		return dao.list(pager);
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
		}
		else if("good_count".equals(item.getType())) {
			dao.goodCount(item);
		}
		else if("bad_count".equals(item.getType())) {
			dao.badCount(item);
		}
	}

	@Override
	public void dummy(Long boardId) {
		for(int i = 0; i < 100; i++) {
			Article item = new Article();
			item.setBoardId(boardId);
			item.setSubject("테스트용 더미 게시글 " + i);
			item.setContents("테스트용 더미 게시글 입니다");
			item.setMemberId("admin");
			dao.add(item);
		}
	}

	@Override
	public void init(Long boardId) {
		ArticlePager pager = new ArticlePager();
		pager.setPerPage(9999);
		pager.setBoardId(boardId);
		List<Article> list = list(pager);
		
		for(Article item : list) {
			delete(boardId, item.getArticleId());
		}
	}
}
