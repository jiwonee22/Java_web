package service.impl;

import java.util.List;

import common.JDBCTemplate;
import dao.face.BoardDao;
import dao.impl.BoardDaoImpl;
import dto.Board;
import service.face.BoardService;

public class BoardServiceImpl implements BoardService {
	
	private BoardDao boardDao = new BoardDaoImpl();
	
	@Override
	public List<Board> getList() {
		return boardDao.selectAll(JDBCTemplate.getConnection());
					
	}

	@Override
	public List<Board> getBoardno() {
		return boardDao.selectBoardByBoardno(JDBCTemplate.getConnection());
	}
	
}
