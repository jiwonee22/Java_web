package web.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.common.JDBCTemplate;
import web.dao.face.BoardDao;
import web.dto.Board;
import web.util.Paging;


public class BoardDaoImpl implements BoardDao {

	private PreparedStatement ps = null; //SQL수행 객체
	private ResultSet rs = null; //조회결과 객체

	@Override
	public List<Board> selectAll(Connection conn) {

		String sql = "";
		sql += "SELECT boardno, title, userid, content, hit, write_date FROM board";
		sql += " ORDER BY boardno DESC";

		List<Board> boardList = new ArrayList<>();

		try {
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while(rs.next() ) {
				Board board = new Board();

				board.setBoardno(rs.getInt("boardno"));
				board.setTitle(rs.getString("title"));
				board.setUserid(rs.getString("userid"));
				board.setContent(rs.getString("content"));
				board.setHit(rs.getInt("hit"));
				board.setWriteDate(rs.getDate("write_date"));

				boardList.add(board);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally { 
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}

		return boardList;
	}

	@Override
	public List<Board> selectAll(Connection conn, Paging paging) {

		String sql ="";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, B.* FROM (";
		sql += "		SELECT";
		sql += "			boardno, title, userid, hit, write_date";
		sql += "		FROM board";
		sql += "		ORDER BY boardno DESC";
		sql += "	) B";
		sql += " ) BOARD";
		sql += " WHERE rnum BETWEEN ? AND ?";

		//결과 저장할 List
		List<Board> boardList = new ArrayList<>();

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());

			rs = ps.executeQuery();

			while(rs.next() ) {
				Board board = new Board();

				board.setBoardno(rs.getInt("boardno"));
				board.setTitle(rs.getString("title"));
				board.setUserid(rs.getString("userid"));
				board.setHit(rs.getInt("hit"));
				board.setWriteDate(rs.getDate("write_date"));

				boardList.add(board);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}

		return boardList;

	}

	@Override
	public int selectCntAll(Connection conn) {

		
		//SQL 작성
		String sql ="";
		sql += "SELECT count(*) FROM board";

		//총 게시글 수
		int count = 0;

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while(rs.next()) {
				count = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}

		return count;
	}
	
	@Override
	public Board selectBoardByBoardno(Connection conn, Board boardno) {
		
		String sql ="";
		sql += "SELECT * FROM board";
		sql += " WHERE boardno = ?";
		
		Board viewBoard = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, boardno.getBoardno());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				viewBoard = new Board();
				
				viewBoard.setBoardno(rs.getInt("boardno"));
				viewBoard.setTitle(rs.getString("title"));
				viewBoard.setUserid(rs.getString("userid"));
				viewBoard.setContent(rs.getString("content"));
				viewBoard.setHit(rs.getInt("hit"));
				viewBoard.setWriteDate(rs.getDate("write_date"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return viewBoard;
	}
	
	@Override
	public int UpdateHit(Connection conn, Board boardno) {
		
		String sql ="";
		sql += "Update board";
		sql += " SET hit = hit + 1";
		sql += " WHERE boardno = ?";
		
		int result = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, boardno.getBoardno());
			
			result = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return result;
		
	}

	
	@Override
	public int insert(Connection conn, Board board) {
		
		String sql = "";
		sql += "INSERT INTO board(boardno, title, userid, content, hit, write_date)";
		sql += " VALUES(boardno_seq.nextval, ?, ?, ?, ?, sysdate)";
		
		int result = 0;
		
		try {
			Board newboard = new Board();
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, newboard.getTitle());
			ps.setString(2, newboard.getUserid());
			ps.setString(3, newboard.getContent());
			ps.setInt(4, newboard.getHit());
			
			rs = ps.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		
		return result;
		
		
	}



}



