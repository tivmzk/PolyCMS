package kr.ac.kopo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.dao.BoardDao;
import kr.ac.kopo.model.Board;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDao dao;
	
	@Override
	public List<Board> list() {
		return dao.list();
	}

	@Override
	public Board item(Long boardId) {
		return dao.item(boardId);
	}

	@Override
	public void add(Board item) {
		dao.add(item);
		
		dao.createTable(item.getBoardId());
		dao.CreateSeq(item.getBoardId());
	}

	@Override
	public void update(Board item) {
		dao.update(item);
	}

	@Override
	public void delete(Long boardId) {
		dao.delete(boardId);
		
		dao.deleteTable(boardId);
		dao.deleteSeq(boardId);
	}

}
