package kr.ac.kopo.aspects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.model.Member;

@Service
public class LogServiceImpl implements LogService {
	@Autowired
	LogDao ld;
	
	@Override
	public void login(Member member, boolean result) {
		ld.login(member, result);
	}

}
