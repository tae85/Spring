package com.kh.ktkimc.board.model.service;

import java.util.List;

import com.kh.ktkimc.board.model.domain.Board;

public interface BoardService {
	int listCount();
	int insertBoard(Board b);
	List<Board> selectList();	// 전체 조회
	Board selectOne(String board_num);
	
//	int addReadCount(String board_num);
	Board updateBoard(Board b);
	void deleteBoard(String board_num);
	
	List<Board> searchList(String keyword);
	List<Board> selectList(int startPage, int limit);
	Board selectBoard(int chk, String board_num);
}
