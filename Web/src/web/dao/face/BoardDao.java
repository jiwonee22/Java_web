package web.dao.face;

import java.sql.Connection;
import java.util.List;

import web.dto.Board;
import web.dto.BoardFile;
import web.util.Paging;

public interface BoardDao {

	/**
	 * Board테이블 전체 조회
	 * 
	 * @param conn - DB연결 객체
	 * @return List<Board> - Board테이블 전체 조회 결과 리스트
	 */
	public List<Board> selectAll(Connection conn);

	/**
	 * Board테이블 전체 조회
	 * 	페이징 처리 추가
	 * 
	 * @param paging - 페이징 정보 객체
	 * @param conn - DB연결 객체
	 * @return List<Board> - Board테이블 전체 조회 결과 리스트
	 */
	public List<Board> selectAll(Connection conn, Paging paging);
	
	/**
	 * 총 게시글 수 조회
	 * 
	 * @param conn - DB연결 객체
	 * @return int - Board테이블 전체 행 수 조회 결과
	 */
	public int selectCntAll(Connection conn);
	
	/**
	 * 특정 게시글 조회
	 * 
	 * @param boardno - 조회할 boardno를 가진 객체
	 * @return Board - 조회된 결과 객체
	 */
	public Board selectBoardByBoardno(Connection conn, Board boardno);

	/**
	 * 조회된 게시글의 조회수 증가시키기
	 * 
	 * @param boardno - 조회된 게시글 번호를 가진 객체
	 */
	public int updateHit(Connection conn, Board boardno);

	/**
	 * id를 이용해 nick을 조회한다
	 * 
	 * @param viewBoard - 조회할 id를 가진 객체
	 * @return String - 작성자 닉네임
	 */
	public String selectNickByUserid(Connection conn, Board viewBoard);
	
	/**
	 * 게시글 입력
	 * 
	 * @param board - 삽입될 게시글 내용
	 */
	public int insert(Connection conn, Board board);

	/**
	 * 다음 게시글 번호 조회
	 * 
	 * 	게시글 테이블과 첨부파일 테이블에 입력될 공통 boardno값을 시퀀스를 통해 조회한다
	 * 
	 * @param conn - DB연결 객체
	 * @return 다음 게시글 번호
	 */
	public int selectNextBoardno(Connection conn);

	/**
	 * 첨부파일 입력
	 * 
	 * @param conn - DB연결 객체
	 * @param boardFile - 첨부파일 정보
	 * @return 삽입 결과
	 */
	public int insertFile(Connection conn, BoardFile boardFile);

	/**
	 * 첨부파일 조회
	 * 
	 * @param connection - DB연결 객체
	 * @param viewBoard - 첨부파일을 조회할 게시글번호 객체
	 * @return BoardFile - 조회된 첨부파일
	 */
	public BoardFile selectFile(Connection conn, Board viewBoard);

	/**
	 * 게시글 선택
	 * 
	 * @param updateBoard - 수정할 게시글
	 * @return board
	 */
	public Board selectByBoardno(Connection conn, Board updateBoard);

	/**
	 * 게시글 수정
	 * 
	 * @param conn
	 * @param board
	 */
	public void update(Connection conn, Board board);

}

















