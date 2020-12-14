package com.kh.ktkimc.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.ktkimc.board.model.dao.BoardReplyDao;
import com.kh.ktkimc.board.model.domain.BoardReply;

@Service("brService")
public class BoardReplyServiceImpl implements BoardReplyService{

	@Autowired
	private BoardReplyDao brDao;
	@Override
	public List<BoardReply> selectList(String board_num) {
		// TODO Auto-generated method stub
		return brDao.selectList(board_num);
	}

	@Override
	public BoardReply selectOne(String comment_id) {
		// TODO Auto-generated method stub
		return brDao.selectOne(comment_id);
	}

	@Override
	public int insertBoardReply(BoardReply br) {
		// TODO Auto-generated method stub
		return brDao.insertBoardReply(br);
	}

	@Override
	public int updateBoardReply(BoardReply br) {
		// TODO Auto-generated method stub
		return brDao.updateBoardReply(br);
	}

	@Override
	public int deleteBoardReply(BoardReply br) {
		// TODO Auto-generated method stub
		return brDao.deleteBoardReply(br);
	}

}
