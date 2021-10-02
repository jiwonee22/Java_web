package dao.face;

import java.sql.Connection;
import java.util.List;

import dto.Board;

public interface BoardDao {

	/**
	 * 게시글 정보 테이블 전체 조회
	 * 
	 * @param connection - DB연결 객체
	 * @return 게시글 전체 테이블 조회결과 List
	 */
	public List<Board> selectAll(Connection connection);

	/**
	 * 게시글 상세 정보 전체 조회
	 * 
	 * @param connection
	 * @return 게시글 전체 상세 정보 List
	 */
	public List<Board> selectBoardByBoardno(Connection connection);

}
