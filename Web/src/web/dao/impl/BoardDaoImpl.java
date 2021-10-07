package web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.common.JDBCTemplate;
import web.dao.face.BoardDao;
import web.dto.Board;
import web.dto.BoardFile;
import web.util.Paging;

public class BoardDaoImpl implements BoardDao {
	
	private PreparedStatement ps = null; //SQL수행 객체
	private ResultSet rs = null; //SQL조회 결과 객체
	
	@Override
	public List<Board> selectAll(Connection conn) {
		
		//SQL 작성
		String sql = "";
		sql += "SELECT * FROM board";
		sql += " ORDER BY boardno DESC";
		
		//결과 저장할 List
		List<Board> boardList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				Board b = new Board(); //결과값 저장 객체
				
				//결과값 한 행 처리
				b.setBoardno( rs.getInt("boardno") );
				b.setTitle( rs.getString("title") );
				b.setUserid( rs.getString("userid") );
				b.setContent( rs.getString("content") );
				b.setHit( rs.getInt("hit") );
				b.setWriteDate( rs.getDate("write_date") );
				
				//리스트에 결과값 저장
				boardList.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		//최종 결과 반환
		return boardList;
	}
	
	@Override
	public List<Board> selectAll(Connection conn, Paging paging) {
		
		//SQL작성
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, B.* FROM (";
		sql += "		SELECT";
		sql += "			boardno, title, userid";
		sql += "			, hit, write_date";
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
			
			while(rs.next()) {
				Board board = new Board();
				
				board.setBoardno( rs.getInt("boardno") );
				board.setTitle( rs.getString("title") );
				board.setUserid( rs.getString("userid") );
				board.setHit( rs.getInt("hit") );
				board.setWriteDate( rs.getDate("write_date") );

				//리스트에 결과값 저장
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
		String sql = "";
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
		
		//SQL 작성
		String sql = "";
		sql += "SELECT * FROM board";
		sql += " WHERE boardno = ?";
		
		//결과 저장할 Board객체
		Board viewBoard = null;
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			ps.setInt(1, boardno.getBoardno()); //조회할 게시글 번호 적용
			
			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				viewBoard = new Board(); //결과값 저장 객체
				
				//결과값 한 행 처리
				viewBoard.setBoardno( rs.getInt("boardno") );
				viewBoard.setTitle( rs.getString("title") );
				viewBoard.setUserid( rs.getString("userid") );
				viewBoard.setContent( rs.getString("content") );
				viewBoard.setHit( rs.getInt("hit") );
				viewBoard.setWriteDate( rs.getDate("write_date") );
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		//최종 결과 반환
		return viewBoard;
	}

	@Override
	public int updateHit(Connection conn, Board boardno) {
		
		//SQL 작성
		String sql = "";
		sql += "UPDATE board";
		sql += " SET hit = hit + 1";
		sql += " WHERE boardno = ?";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			ps.setInt(1, boardno.getBoardno()); //조회할 게시글 번호 적용
			
			res = ps.executeUpdate(); //SQL 수행
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(ps);
		}
		
		return res;
	}
	
	@Override
	public String selectNickByUserid(Connection conn, Board viewBoard) {
		
		//SQL 작성
		String sql = "";
		sql += "SELECT usernick FROM member";
		sql += " WHERE userid = ?";
		
		//결과 저장할 String 변수
		String usernick = null;
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			ps.setString(1, viewBoard.getUserid()); //조회할 id 적용
			
			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				usernick = rs.getString("usernick");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		//최종 결과 반환
		return usernick;
		
	}
	
	@Override
	public int insert(Connection conn, Board board) {
		
		//다음 게시글 번호 조회 쿼리
		String sql = "";
		sql += "INSERT INTO board(BOARDNO, TITLE, USERID, CONTENT, HIT)";
		sql += " VALUES (?, ?, ?, ?, 0)";
		
//		sql += " VALUES (board_seq.nextval, ?, ?, ?, 0)";
		
		int res = 0;
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, board.getBoardno());
			ps.setString(2, board.getTitle());
			ps.setString(3, board.getUserid());
			ps.setString(4, board.getContent());
			
//			ps.setString(1, board.getTitle());
//			ps.setString(2, board.getUserid());
//			ps.setString(3, board.getContent());

			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}

	@Override
	public int selectNextBoardno(Connection conn) {
		
		String sql = "";
		sql += "SELECT board_seq.nextval FROM dual";
		
		//결과 저장 변수
		int nextBoardno = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				nextBoardno = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return nextBoardno;
	}
	
	@Override
	public int insertFile(Connection conn, BoardFile boardFile) {

		String sql = "";
		sql += "INSERT INTO boardfile( fileno, boardno, originname, storedname, filesize )";
		sql += " VALUES( boardfile_seq.nextval, ?, ?, ?, ? )";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, boardFile.getBoardno());
			ps.setString(2, boardFile.getOriginname());
			ps.setString(3, boardFile.getStoredname());
			ps.setInt(4, boardFile.getFilesize());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}
	
	@Override
	public BoardFile selectFile(Connection conn, Board viewBoard) {
		
		String sql = "";
		sql += "SELECT * FROM boardfile";
		sql += " WHERE boardno = ?";

		BoardFile boardFile = null;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, viewBoard.getBoardno());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				boardFile = new BoardFile();
				
				boardFile.setFileno( rs.getInt("fileno") );
				boardFile.setBoardno( rs.getInt("boardno") );
				boardFile.setOriginname( rs.getString("originname") );
				boardFile.setStoredname( rs.getString("storedname") );
				boardFile.setFilesize( rs.getInt("filesize") );
				boardFile.setWrite_date( rs.getDate("write_date") );
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
				
		return boardFile;
	}
	
	@Override
	public Board selectByBoardno(Connection conn, Board updateBoard) {
		
		String sql = "";
		sql += "SELECT * FROM board";
		sql += " WHERE boardno = ?";
		
		Board board = new Board();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, updateBoard.getBoardno());
			
			rs = ps. executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return board;
		
	}
	
	@Override
	public int update(Connection conn, Board board) {

		String sql = "";
		sql += "UPDATE board";
		sql += " SET title = ?,";
		sql += " content = ?";
		sql += " WHERE boardno = ?";
		
		int res = -1;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, board.getTitle() );
			ps.setString(2, board.getContent() );
			ps.setInt(3, board.getBoardno() );
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		return res;
				
	}
	
	@Override
	public int delete(Connection conn, Board boardno) {
		
		String sql = "";
		sql += "DELETE boardfile";
		sql += " WHERE boardno = ? ";
		
		int res = -1;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, boardno.getBoardno());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}
	
	@Override
	public int deleteFile(Connection conn, Board boardno) {
		
		String sql = "";
		sql += "DELETE board";
		sql += " WHERE boardno = ? ";
		
		int res = -1;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, boardno.getBoardno());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
		
	}
}





















