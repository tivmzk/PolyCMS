package kr.ac.kopo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.model.Member;
import kr.ac.kopo.service.MemberService;

@Controller
public class RootController {
	@Autowired
	MemberService ms;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(Member item, HttpSession session) {
		if(ms.login(item)) {
			session.setAttribute("member", item);
			return "redirect:/";
		}
		else {
			return "redirect:login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
