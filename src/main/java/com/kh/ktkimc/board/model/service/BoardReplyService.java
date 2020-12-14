package com.kh.ktkimc.board.model.service;

import java.util.List;

import com.kh.ktkimc.board.model.domain.BoardReply;

public interface BoardReplyService {
	
	List<BoardReply> selectList(String board_num);
	
	BoardReply selectOne(String comment_id);
	
	int insertBoardReply(BoardReply br);
	
	int updateBoardReply(BoardReply br);
	
	int deleteBoardReply(BoardReply br);
}
