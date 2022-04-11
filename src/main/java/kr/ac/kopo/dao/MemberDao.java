package kr.ac.kopo.dao;

import java.util.List;

import kr.ac.kopo.model.Member;
import kr.ac.kopo.util.Pager;

public interface MemberDao {

	Long total(Pager pager);

	List<Member> list(Pager pager);

	Member item(String id);

	void update(Member item);

	void delete(String id);

	void add(Member item);

	Member login(Member item);

}
