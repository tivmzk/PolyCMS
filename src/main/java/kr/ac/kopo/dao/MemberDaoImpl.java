package kr.ac.kopo.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.model.Member;
import kr.ac.kopo.util.Pager;

@Repository
public class MemberDaoImpl implements MemberDao {
	@Autowired
	SqlSession sql;
	
	final String namespace = "member.";
	
	@Override
	public Long total(Pager pager) {
		return sql.selectOne(namespace+"total", pager);
	}

	@Override
	public List<Member> list(Pager pager) {
		return sql.selectList(namespace+"list", pager);
	}

	@Override
	public Member item(String id) {
		return sql.selectOne(namespace+"item", id);
	}

	@Override
	public void update(Member item) {
		sql.update(namespace+"update", item);
	}

	@Override
	public void delete(String id) {
		sql.delete(namespace+"delete", id);
	}

	@Override
	public void add(Member item) {
		sql.insert(namespace+"add", item);
	}

	@Override
	public Member login(Member item) {
		return sql.selectOne(namespace+"login", item);
	}

}
