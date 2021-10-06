package web.service.impl;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import web.common.JDBCTemplate;
import web.dao.face.BoardDao;
import web.dao.impl.BoardDaoImpl;
import web.dto.Board;
import web.dto.BoardFile;
import web.service.face.BoardService;
import web.util.Paging;

public class BoardServiceImpl implements BoardService {

	//BoardDao 객체 생성
	private BoardDao boardDao = new BoardDaoImpl();

	@Override
	public List<Board> getList() {

		//게시글 전체 조회 결과 처리
		return boardDao.selectAll(JDBCTemplate.getConnection());

	}

	@Override
	public List<Board> getList(Paging paging) {

		//게시글 전체 조회 결과 처리 - 페이징 추가
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
			System.out.println("[WARNING] curPage값이 null이거나 비어있습니다");
		}

		//Board 테이블의 총 게시글 수를 조회한다
		int totalCount = boardDao.selectCntAll(JDBCTemplate.getConnection());

		//Paging객체 생성
		Paging paging = new Paging(totalCount, curPage);

		return paging;
	}

	@Override
	public Board getBoardno(HttpServletRequest req) {

		//boardno를 저장할 객체 생성
		Board boardno = new Board();

		//boardno 전달파라미터 검증 - null, ""
		String param = req.getParameter("boardno");
		if(param!=null && !"".equals(param)) {

			//boardno 전달파라미터 추출
			boardno.setBoardno( Integer.parseInt(param) );
		}

		//결과 객체 반환
		return boardno;
	}

	@Override
	public Board view(Board boardno) {

		Connection conn = JDBCTemplate.getConnection();

		//조회수 증가
		if( boardDao.updateHit(conn, boardno) == 1 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		//게시글 조회
		Board board = boardDao.selectBoardByBoardno(conn, boardno); 

		return board;
	}

	@Override
	public String getNick(Board viewBoard) {
		return boardDao.selectNickByUserid(JDBCTemplate.getConnection(), viewBoard);
	}

	@Override
	public void write(HttpServletRequest req) {

		//--- 첨부파일 없이 게시글 작성 처리 ---

		//		Board board = new Board();
		//
		//		board.setTitle( req.getParameter("title") );
		//		board.setContent( req.getParameter("content") );
		//
		//		//작성자id 처리
		//		board.setUserid((String) req.getSession().getAttribute("userid"));
		//
		//		if(board.getTitle()==null || "".equals(board.getTitle())) {
		//			board.setTitle("(제목없음)");
		//		}
		//
		//		Connection conn = JDBCTemplate.getConnection();
		//		if( boardDao.insert(conn, board) > 0 ) {
		//			JDBCTemplate.commit(conn);
		//		} else {
		//			JDBCTemplate.rollback(conn);
		//		}

		//--------------------------------------


		//**첨부파일 추가하여 글 작성 처리

		//게시글 정보 DTO 객체
		Board board = null;

		//첨부파일 정보 DTO 객체
		BoardFile boardFile = null;




		//파일업로드 형태의 데이터가 맞는지 검사
		boolean isMultipart = false;
		isMultipart = ServletFileUpload.isMultipartContent(req);

		if( !isMultipart ) {
			System.out.println("[ERROR] multipart/form-data 형식이 아님");

			return; //write() 메소드 중단
		}




		//게시글 정보를 저장할 DTO객체 생성
		board = new Board();




		//디스크기반 아이템 팩토리
		DiskFileItemFactory factory = new DiskFileItemFactory();

		//메모리 처리 사이즈 지정
		factory.setSizeThreshold(1 * 1024 * 1024); //1MB

		//임시 저장소 설정
		File repository = new File(req.getServletContext().getRealPath("tmp"));
		repository.mkdir(); //임시 저장소 폴더 생성
		factory.setRepository(repository); //임시 저장소 폴더 지정




		//파일업로드 객체 생성
		ServletFileUpload upload = new ServletFileUpload(factory);

		//업로드 용량 제한
		upload.setFileSizeMax(10 * 1024 * 1024); //10MB




		//전달 데이터 파싱
		List<FileItem> items = null;
		try {
			items = upload.parseRequest(req);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}

		//파싱된 전달파라미터를 처리할 반복자
		Iterator<FileItem> iter = items.iterator();

		while( iter.hasNext() ) { //모든 요청 정보 처리
			FileItem item = iter.next();



			//--- 1) 빈 파일에 대한 처리 ---
			if( item.getSize() <= 0 ) {
				continue; //빈 파일은 무시하고 다음 FileItem처리로 넘긴다
			}



			//--- 2) form-data에 대한 처리 ---
			if( item.isFormField() ) {
				//키 추출하기
				String key = item.getFieldName();

				//값 추출하기
				String value = null;
				try {
					value = item.getString("UTF-8");
				} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
				}

				//키(name)에 따라서 value저장하기
				if( "title".equals(key) ) {
					board.setTitle( value );
				} else if( "content".equals(key) ) {
					board.setContent( value );
				}

			} //if( item.isFormField() ) end



			//--- 3) 파일에 대한 처리 ---
			if( !item.isFormField() ) {

				//UUID 생성
				UUID uuid = UUID.randomUUID(); //랜덤 UUID
				String uid = uuid.toString().split("-")[0]; //8자리 uuid

				//로컬 저장소의 업로드 폴더
				File upFolder = new File(req.getServletContext().getRealPath("upload"));
				upFolder.mkdir(); //폴더 생성

				//업로드 파일 객체
				String origin = item.getName(); //원본파일명
				String stored = origin + "_" + uid; //원본파일명_uid
				File up = new File(upFolder, stored);



				try {
					item.write(up); //실제 업로드(임시파일을 최종결과파일로 생성함)
					item.delete(); //임시파일을 삭제
				} catch (Exception e) {
					e.printStackTrace();
				}



				//업로드된 파일의 정보 저장
				boardFile = new BoardFile();
				boardFile.setOriginname(origin);
				boardFile.setStoredname(stored);
				boardFile.setFilesize( (int)item.getSize() );

			} //if( !item.isFormField() ) end
		} //while( iter.hasNext() ) end




		//DB연결 객체
		Connection conn = JDBCTemplate.getConnection();

		//게시글 번호 생성 - DAO 이용
		int boardno = boardDao.selectNextBoardno(conn);




		//게시글 정보가 있을 경우
		if(board != null) {

			//작성자 userid 입력
			board.setUserid( (String)req.getSession().getAttribute("userid") );

			board.setBoardno(boardno); //게시글 번호 입력 (PK)

			if(board.getTitle()==null || "".equals(board.getTitle())) {
				board.setTitle("(제목없음)");
			}

			if( boardDao.insert(conn, board) > 0 ) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
		}

		//첨부파일 정보가 있을 경우
		if(boardFile != null) {
			boardFile.setBoardno(boardno); //게시글 번호 입력 (FK)

			if( boardDao.insertFile(conn, boardFile) > 0 ) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
		}

	}
	
	@Override
	public BoardFile viewFile(Board viewBoard) {
		return boardDao.selectFile(JDBCTemplate.getConnection(), viewBoard);
	}

	@Override
	public void update(Board updateBoard) {

		Board board = new Board();
		board = boardDao.selectByBoardno(JDBCTemplate.getConnection(), updateBoard);

		Connection conn = JDBCTemplate.getConnection();
		boardDao.update(conn, board);


	}
	


}






















