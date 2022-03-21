package kr.ac.kopo.service;

import java.util.List;

import kr.ac.kopo.model.Board;

public interface BoardService {

	List<Board> list();

	Board item(Long boardId);

	void add(Board item);

	void update(Board item);

	void delete(Long boardId);

}
