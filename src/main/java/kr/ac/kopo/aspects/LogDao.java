package kr.ac.kopo.aspects;

import kr.ac.kopo.model.Member;

public interface LogDao {

	void login(Member member, boolean result);

}
