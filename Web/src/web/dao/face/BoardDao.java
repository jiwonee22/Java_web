package web.dao.face;

import java.sql.Connection;
import java.util.List;

import web.dto.Board;
import web.util.Paging;



public interface BoardDao {

	/**
	 * Board 테이블 전체 조회
	 * 
	 * @param connection - DB연결 객체
	 * @return List<Board> - 게시글 전체 테이블 조회결과 List
	 */
	public List<Board> selectAll(Connection conn);
	
	/**
	 * 
	 * @param connection
	 * @param paging
	 * @return List<Board>
	 */
	public List<Board> selectAll(Connection conn, Paging paging);

	/**
	 * 총 게시글 수 조회
	 * 
	 * @param connection - DB연결 객체
	 * @return int - Board테이블 전체 행 수 조회 결과
	 */
	public int selectCntAll(Connection conn);

	/**
	 * 게시글 번호로 게시글 상세 조회하기
	 * 
	 * @param conn - DB연결 객체
	 * @param board - 
	 * @return viewBoard
	 */
	public Board selectBoardByBoardno(Connection conn, Board boardno);

	/**
	 * 조회수 + 1
	 * 
	 * @param conn
	 * @param boardno - 조회된 게시글 번호를 가진 객체
	 * 
	 */
	public int UpdateHit(Connection conn, Board boardno);





}
