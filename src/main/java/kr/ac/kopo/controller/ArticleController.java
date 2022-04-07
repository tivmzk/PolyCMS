package kr.ac.kopo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.kopo.model.Article;
import kr.ac.kopo.model.ArticleCount;
import kr.ac.kopo.service.ArticleService;
import kr.ac.kopo.util.Pager;

@Controller
@RequestMapping("/board/{boardId}/article")
public class ArticleController {
	@Autowired
	ArticleService service;
	
	final String PATH = "article/";
	
	@GetMapping("/list")
	public String list(@PathVariable Long boardId, Model model, Pager pager) {
		List<Article> list = service.list(boardId, pager);
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
		model.addAttribute("item", item);
		return PATH+"view";
	}
	
	@PostMapping("/view/{articleId}")
	@ResponseBody
	public ArticleCount view(@PathVariable Long boardId, @PathVariable Long articleId, @RequestBody ArticleCount item) {
		item.setBoardId(boardId);
		item.setArticleId(articleId);
		service.updateCount(item);
		
		return item;
	}
	
	@GetMapping("/dummy")
	public String dummy(@PathVariable Long boardId) {
		service.dummy(boardId);
		return "redirect:list";
	}
	
	@GetMapping("/init")
	public String init(@PathVariable Long boardId) {
		service.init(boardId);
		return "redirect:list";
	}
}
