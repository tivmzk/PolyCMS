package kr.ac.kopo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.aspects.PointcutLogin;
import kr.ac.kopo.dao.MemberDao;
import kr.ac.kopo.model.Member;
import kr.ac.kopo.util.Pager;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberDao md;
	
	@Override
	public List<Member> list(Pager pager) {
		Long total = md.total(pager);
		pager.setTotal(total);
		return md.list(pager);
	}

	@Override
	public Member item(String id) {
		return md.item(id);
	}

	@Override
	public void update(Member item) {
		md.update(item);
	}

	@Override
	public void delete(String id) {
		md.delete(id);
	}

	@Override
	public void add(Member item) {
		md.add(item);
	}

	@PointcutLogin
	@Override
	public boolean login(Member item) {
		Member member = md.login(item);
		
		if(member != null) {
			item.setName(member.getName());
			item.setGrade(member.getGrade());
			item.setRegDate(member.getRegDate());
			item.setPasswd("");
			return true;
		}
		
		return false;
	}

}
