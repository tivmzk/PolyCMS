package kr.ac.kopo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.model.Article;
import kr.ac.kopo.service.ArticleService;

@Controller
@RequestMapping("/board/{boardId}/article")
public class ArticleController {
	@Autowired
	ArticleService service;
	
	final String PATH = "article/";
	
	@GetMapping("/list")
	public String list(@PathVariable Long boardId, Model model) {
		List<Article> list = service.list(boardId);
		model.addAttribute("list", list);
		return PATH+"list";
	}
	
	@GetMapping("/add")
	public String add() {
		return PATH+"add";
	}
	
	@PostMapping("/add")
	public String add(@PathVariable Long boardId, Article item) {
		item.setBoardId(boardId);
		service.add(item);
		return "redirect:list";
	}
	
	@GetMapping("/update/{articleId}")
	public String update(@PathVariable Long boardId, @PathVariable Long articleId, Model model) {
		Article item = service.item(boardId, articleId);
		model.addAttribute("item", item);
		return PATH+"update";
	}
	
	@PostMapping("/update/{articleId}")
	public String update(@PathVariable Long boardId, @PathVariable Long articleId, Article item) {
		item.setBoardId(boardId);
		item.setArticleId(articleId);
		service.update(item);
		return "redirect:../list";
	}
	
	@GetMapping("/delete/{articleId}")
	public String delete(@PathVariable Long boardId, @PathVariable Long articleId) {
		service.delete(boardId, articleId);
		return "redirect:../list";
	}
	
	@GetMapping("/view/{articleId}")
	public String view(@PathVariable Long boardId, @PathVariable Long articleId, Model model) {
		Article item = service.item(boardId, articleId);
		service.counting(boardId, articleId, item.getViewCount(), "view_count");
		model.addAttribute("item", item);
		return PATH+"view";
	}
}
