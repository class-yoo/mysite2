package com.cafe24.mysite.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.mysite.vo.BoardVo;

@Repository
public class BoardDao {

	@Autowired
	SqlSession sqlSession;

	public List<BoardVo> selectBoardList() {
		return sqlSession.selectList("board.getBoardList");
	}

	public BoardVo selectBoardByNo(Long boardNo) {

		return sqlSession.selectOne("board.getBoardByNo", boardNo);
	}

	public int insertBoard(BoardVo boardVo) {

		return sqlSession.insert("board.insertBoard", boardVo);
	}

	public int insertReplyBoard(BoardVo boardVo) {

		return sqlSession.insert("board.insertReplyBoard", boardVo);
	}

	public int increaseOrderNo(BoardVo boardVo) {
		
		return sqlSession.update("board.increaseOrderNo", boardVo);
	}

	public int updateBoard(BoardVo boardVo) {

		return sqlSession.update("board.updateBoard", boardVo);
	}

}
