package kr.ac.kopo.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.ac.kopo.model.Member;

public class AdminInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		String path = request.getContextPath();
		Member member = (Member) session.getAttribute("member");
		
		if(member == null) {
			response.sendRedirect(path+"/login");
			return false;
		}
		
		System.out.println(String.format("%s님이 관리자 페이지에 접근했습니다.", member.getId()));
		if(member.getGrade() < 100) {
			response.sendRedirect(path+"/");
			System.out.println(String.format("접근 실패 : 관리자 계정이 아닙니다."));
			return false;
		}
		System.out.println(String.format("접근 성공 : %s님이 접근했습니다.", member.getId()));
		return true;
	}
}
