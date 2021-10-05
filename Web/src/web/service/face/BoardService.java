package web.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dto.Board;
import web.util.Paging;

public interface BoardService {

	/**
	 * 게시글 전체 목록을 조회한다
	 * 
	 * @return 조회된 게시글 전체 목록
	 */
	public List<Board> getList();
	
	/**
	 * 게시글 전체 목록을 조회한다
	 * 페이징 처리 추가
	 * 
	 * @param paging - 페이징 정보 객체 
	 * @return 조회된 게시글 전체 목록
	 */
	public List<Board> getList(Paging paging);

	/**
	 * 페이징 객체 생성
	 * 
	 * 요청 파라미터 curPage를 구한다
	 * Board테이블과 curPage값을 이용하여 Paging객체를 구하여 반환한다
	 * 
	 * @param req - 요청정보 객체
	 * @return - 페이징 계산이 완료된 Paging 객체
	 */
	public Paging getPaging(HttpServletRequest req);

	/**
	 * 요청 파라미터 얻기
	 * 
	 * @param req - 요청 정보 
	 * @return - 전달파라미터 boardno를 저장한 객체
	 */
	public Board getBoardno(HttpServletRequest req);
	
	/**
	 * board 게시글 상세 조회
	 * 조회하면 hit + 1
	 * 
	 * @param boardno - boardno를 가지고 있는객체 
	 * @return Board
	 */
	public Board view(Board boardno);

	
	/** 
	 * board 게시글 작성
	 * 
	 * @param board
	 */
	public void write(Board board);



	

	

}
