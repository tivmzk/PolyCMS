package kr.ac.kopo.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.kopo.model.Article;
import kr.ac.kopo.service.ArticleService;

@RestController
@RequestMapping("/rest/article")
public class ArticleRestController {
	@Autowired
	ArticleService service;
	
	@PutMapping("/good")
	public Article good(@RequestBody Article item) {
		Article article = service.item(item.getBoardId(), item.getArticleId());
		article.setBoardId(item.getBoardId());
		service.counting(article.getBoardId(), article.getArticleId(), article.getGoodCount(), "good_count");
		article.setGoodCount(article.getGoodCount()+1);
		return article;
	}
	
	@PutMapping("/bad")
	public Article bad(@RequestBody Article item) {
		Article article = service.item(item.getBoardId(), item.getArticleId());
		article.setBoardId(item.getBoardId());
		service.counting(article.getBoardId(), article.getArticleId(), article.getBadCount(), "bad_count");
		article.setBadCount(article.getBadCount()+1);
		return article;
	}
}
