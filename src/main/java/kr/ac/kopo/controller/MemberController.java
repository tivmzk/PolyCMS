package kr.ac.kopo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.model.Member;
import kr.ac.kopo.service.MemberService;
import kr.ac.kopo.util.Pager;

@Controller
@RequestMapping("/member")
public class MemberController {
	final String path = "member/";
	
	@Autowired
	MemberService ms;
	
	@GetMapping("/list")
	public String list(Pager pager, Model model) {
		List<Member> list = ms.list(pager);
		model.addAttribute("list", list);
		return path+"list";
	}
	
	@GetMapping("/add")
	public String add() {
		return path+"add";
	}
	
	@PostMapping("/add")
	public String add(Member item) {
		ms.add(item);
		return "redirect:list";
	}
	
	@GetMapping("/update/{id}")
	public String update(Model model, @PathVariable String id) {
		Member item = ms.item(id);
		model.addAttribute("item", item);
		return path+"update";
	}
	
	@PostMapping("/update/{id}")
	public String update(@PathVariable String id, Member item) {
		item.setId(id);
		ms.update(item);
		return "redirect:../list";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable String id) {
		ms.delete(id);
		return "redirect:../list";
	}
}