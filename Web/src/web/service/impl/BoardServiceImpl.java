package web.service.impl;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.common.JDBCTemplate;
import web.dao.face.BoardDao;
import web.dao.impl.BoardDaoImpl;
import web.dto.Board;
import web.service.face.BoardService;
import web.util.Paging;

public class BoardServiceImpl implements BoardService {

	private BoardDao boardDao = new BoardDaoImpl();

	@Override
	public List<Board> getList() {
		return boardDao.selectAll(JDBCTemplate.getConnection());

	}

	@Override
	public List<Board> getList(Paging paging) {
		return boardDao.selectAll(JDBCTemplate.getConnection(), paging);

	}

	@Override
	public Paging getPaging(HttpServletRequest req) {

		//전달파라미터 curPage 파싱
		String param = req.getParameter("curPage");
		int curPage = 0;
		if(param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		} else {
			System.out.println("[ERROR] curPage값이 null이거나 비어있습니다");
		}

		//Board 테이블의 총 게시글 수를 조회한다
		int totalCount = boardDao.selectCntAll(JDBCTemplate.getConnection());

		//Paging객체 생성
		Paging paging = new Paging(totalCount, curPage);

		return paging;
	}

	@Override
	public Board getBoardno(HttpServletRequest req) {

		Board boardno = new Board();
		
		String param = req.getParameter("boardno");

		if(param != null && !"".equals(param)) {
			boardno.setBoardno( Integer.parseInt(param) );
		}

		return boardno;
	}

	@Override
	public Board view(Board boardno) {
		
		Connection conn = JDBCTemplate.getConnection();

		if(boardDao.UpdateHit(conn, boardno) == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		Board board = boardDao.selectBoardByBoardno(conn, boardno);
		
		return board;
		

	}
	
	@Override
	public void write(Board board) {
		
		Connection conn = JDBCTemplate.getConnection();
		int res = boardDao.insert(conn, board);
		
		if(res > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
	}


}


