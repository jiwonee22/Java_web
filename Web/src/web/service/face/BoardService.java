package web.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dto.Board;
import web.dto.BoardFile;
import web.util.Paging;

public interface BoardService {

	/**
	 * 게시글 전체 조회
	 * 
	 * @return List<Board> - 게시글 전체 조회 결과 리스트
	 */
	public List<Board> getList();

	/**
	 * 게시글 전체 조회
	 * 	페이징 처리 추가
	 * 
	 * @param paging - 페이징 정보 객체
	 * @return List<Board> - 게시글 전체 조회 결과 리스트
	 */
	public List<Board> getList(Paging paging);
	
	/**
	 * 페이징 객체 생성
	 * 
	 * 요청파라미터 curPage를 구한다
	 * Board테이블과 curPage값을 이용하여 Paging객체를 구하여 반환한다
	 * 
	 * @param req - 요청정보 객체
	 * @return 페이징 계산이 완료된 Paging 객체
	 */
	public Paging getPaging(HttpServletRequest req);
	
	/**
	 * 요청파라미터 얻기
	 * 
	 * @param req - 요청정보객체
	 * @return Board - 전달파라미터 boardno를 포함한 객체
	 */
	public Board getBoardno(HttpServletRequest req);

	/**
	 * 주어진 boardno를 이용하여 게시글을 조회한다
	 * 조회된 게시글의 조회수를 1 증가시킨다
	 * 
	 * @param boardno - boardno를 가지고 있는 객체
	 * @return Board - 조회된 게시글
	 */
	public Board view(Board boardno);
	
	/**
	 * Board 객체의 id 를 이용한 닉네임 조회
	 * 
	 * @param viewBoard - 조회할 게시글 정보
	 * @return String - 게시글 작성자의 닉네임
	 */
	public String getNick(Board viewBoard);
	
	/**
	 * 게시글 작성
	 * 	입력한 게시글 내용을 DB에 저장
	 * 
	 *  [ 추가 예정 ] 첨부파일을 함께 업로드 할 수 있도록 처리
	 * 
	 * @param req - 요청정보 객체(게시글내용 + 첨부파일)
	 * 
	 */
	public void write(HttpServletRequest req);

	/**
	 * 첨부파일 정보 조회
	 * 
	 * @param viewBoard - 첨부파일과 연결된 게시글번호를 포함한 DTO객체
	 * @return BoardFile - 첨부파일 정보 DTO객체
	 */
	public BoardFile viewFile(Board viewBoard);

	/** 
	 * 게시글 수정
	 * 
	 * @param req - 요청 정보
	 */
	public void update(HttpServletRequest req);

	/**
	 * 게시글 삭제
	 * 
	 * @param boardno - 요청 저보
	 */
	public void delete(Board boardno);


	


	

}















