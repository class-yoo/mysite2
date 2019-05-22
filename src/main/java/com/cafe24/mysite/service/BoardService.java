package com.cafe24.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.mysite.repository.BoardDao;
import com.cafe24.mysite.vo.BoardVo;

@Service
public class BoardService {

	@Autowired
	private BoardDao boardDao;

	public List<BoardVo> getBoardList() {
		return boardDao.selectBoardList();
	}

	public BoardVo getBoardByNo(Long boardNo) {
		return boardDao.selectBoardByNo(boardNo);
	}

	public Boolean createBoard(BoardVo boardVo) {

		return 1 == boardDao.insertBoard(boardVo);
	}
	
	public Boolean createReplyBoard(BoardVo boardVo) {
		boardDao.increaseOrderNo(boardVo);
		
		return 1 == boardDao.insertReplyBoard(boardVo);
	}
	
	public Boolean modify(BoardVo boardVo) {

		return 1 == boardDao.updateBoard(boardVo);
	}

	public Boolean removeBoard(Long boardNo) {
		
		return 1 == boardDao.deleteBoard(boardNo);
	}

}
