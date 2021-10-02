package service.face;

import java.util.List;

import dto.Board;

public interface BoardService {

	/**
	 * 게시글 전체 목록을 조회한다
	 * 
	 * @return 조회된 게시글 전체 목록
	 */
	public List<Board> getList();

	/**
	 * 게시글 상세 내용을 조회한다
	 * 
	 * @return 조회된 게시글 상새 내용
	 */
	public List<Board> getBoardno();

	

	

}
