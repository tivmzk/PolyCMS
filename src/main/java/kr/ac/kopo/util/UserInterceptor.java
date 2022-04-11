package kr.ac.kopo.util;

import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.ac.kopo.model.Member;

public class UserInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		String path = request.getContextPath();
		
		if(member == null) {
			URL url = new URL(request.getRequestURL().toString()+"?"+request.getQueryString());
			
			String query = "?"+url.getQuery();
			String target = url.getPath() + (query != null ? query : "");
			
			target = target.replace("/kopo", "");
			
			session.setAttribute("target", target);
			
			response.sendRedirect(path+"/login");
			return false;
		}
		
		return true;
	}
}
