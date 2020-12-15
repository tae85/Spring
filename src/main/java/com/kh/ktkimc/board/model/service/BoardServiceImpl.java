package com.kh.ktkimc.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.ktkimc.board.model.dao.BoardDao;
import com.kh.ktkimc.board.model.domain.Board;

@Service("bService")
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDao bDao;
	
	@Override
	public int listCount() {
		return bDao.listCount();
	}

	@Override
	public int insertBoard(Board b) {
		return bDao.insertBoard(b);
	}

	@Override
	public List<Board> selectList() {
		return bDao.selectList();
	}

	@Override
	public Board selectOne(String board_num) {	// 게시글 1개 읽기
		bDao.addReadCount(board_num);
		return bDao.selectOne(board_num);
	}

//	@Override
//	public int addReadCount(String board_num) {
//		return bDao.addReadCount(board_num);
//	}

	@Override
	public Board updateBoard(Board b) {
		int result = bDao.updateBoard(b);
		if(result > 0) {
			b=bDao.selectOne(b.getBoard_num());
		} else {
			b=null;
		}
		return b;
	}

	@Override
	public void deleteBoard(String board_num) {
		bDao.deleteBoard(board_num);
	}

	@Override
	public List<Board> searchList(String keyword) {
		return bDao.searchList(keyword);
	}

	@Override
	public List<Board> selectList(int startPage, int limit) {
		return bDao.selectList(startPage, limit);
	}

	@Override
	public Board selectBoard(int chk, String board_num) {
		if(chk==0) bDao.addReadCount(board_num);
		return bDao.selectOne(board_num);
	}

}
