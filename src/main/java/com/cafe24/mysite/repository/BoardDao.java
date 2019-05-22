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

	public int deleteBoard(Long boardNo) {

		//댓글을 삭제할때 삭제되는 답글의 depth 보다 크면서 삭제되는 답글의 orderno 보다 크고 뎁스가 똑같은 답글중에서 가장
		//작은 오더넘버를 갖는 답글의 orderno보다 작은 답글들을 삭제한다. 
		//삭제되는 소그룹의 마지막답글의 오더넘버보다 큰애들의 오더넘버를 삭제되는 답글의 숫자만큼 감소시켜준다. > 일단 보류

		return sqlSession.delete("board.deleteBoard", boardNo);
	}

	public int getTotalBoardCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int getsearchBoardCount(String kwd) {
		// TODO Auto-generated method stub
		return 0;
	}

}
