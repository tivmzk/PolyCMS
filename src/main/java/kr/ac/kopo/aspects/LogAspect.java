package kr.ac.kopo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.ac.kopo.model.Article;
import kr.ac.kopo.model.Member;

@Aspect
@Component
public class LogAspect {
	@Autowired
	LogService ls;
	
	@AfterReturning(pointcut="@annotation(PointcutLogin) && args(member)", returning="result")
	public void logoLogin(JoinPoint joinPoint, Member member, boolean result) {
		System.out.println(String.format("로그인 : %s -> %b", member.getId(), result));
		ls.login(member, result);
	}
	
	@Before("execution(* kr.ac.kopo.service.ArticleService*.add(..)) && args(item)")
	public void logArticleAdd(Article item) {
		System.out.println(String.format("(%d) 새로운 글 등록 : %s -> %s", item.getBoardId(), item.getMemberId(), item.getSubject()));
		
	}
}
