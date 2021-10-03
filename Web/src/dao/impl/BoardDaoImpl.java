package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import dao.face.BoardDao;
import dto.Board;

public class BoardDaoImpl implements BoardDao {
	
	private PreparedStatement ps = null; //SQL수행 객체
	private ResultSet rs = null; //조회결과 객체

	@Override
	public List<Board> selectAll(Connection connection) {
		
		String sql = "";
		sql += "SELECT boardno, title, userid, content, hit, write_date FROM board";
		sql += " ORDER BY boardno DESC";
		
		List<Board> list = new ArrayList<>();
		
		try {
			ps = connection.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next() ) {
				Board board = new Board();
				
				board.setBoardNo(rs.getInt("boardno"));
				board.setTitle(rs.getString("title"));
				board.setUserId(rs.getString("userid"));
				board.setContent(rs.getString("content"));
				board.setHit(rs.getInt("hit"));
				board.setWriteDate(rs.getDate("write_date"));
				
				list.add(board);
		
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally { 
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return list;
	}
	
	@Override
	public List<Board> selectBoardByBoardno(Connection connection) {

		String sql = "";
		sql += "SELECT boardno, title, userid, content, hit, write_date FROM board";
		sql += " WHERE boardno = ?";
				
		List<Board> list = new ArrayList<>();
		
		try {
			ps = connection.prepareStatement(sql);
			
//			ps.setInt(1, boardno);
			
			rs = ps.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		return null;
	}
	
}
