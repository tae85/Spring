package com.kh.ktkimc.board.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.ktkimc.board.model.domain.BoardReply;

@Repository("brDao")
public class BoardReplyDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<BoardReply> selectList(String board_num){
		return sqlSession.selectList("BoardReply.selectBoardReplyAll", board_num);
	}
	
	public BoardReply selectOne(String comment_id){
		return sqlSession.selectOne("BoardReply.selectBoardReply", comment_id);
	}
	
	public int insertBoardReply(BoardReply br) {
		return sqlSession.insert("BoardReply.insertBoardReply", br);
	}
	
	public int updateBoardReply(BoardReply br) {
		System.out.println(br);
		return sqlSession.update("BoardReply.updateBoardReply", br);
	}
	
	public int deleteBoardReply(BoardReply br) {
		System.out.println(br);
		return sqlSession.delete("BoardReply.deleteBoardReply", br);
	}
}
