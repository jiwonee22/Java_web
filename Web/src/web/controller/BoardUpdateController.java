package web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.Board;
import web.dto.BoardFile;
import web.service.face.BoardService;
import web.service.impl.BoardServiceImpl;

@WebServlet("/board/update")
public class BoardUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardService boardService = new BoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/board/update [GET]");
		
		//전달 파라미터 얻기 - boardno
		Board boardno = boardService.getBoardno(req);
		
		//상세보기 결과 조회
		Board updateBoard = boardService.view(boardno);

		//닉네임 가져오기(닉네임은 member객체에만 있고 board객체에는 없기때문에.)
		req.setAttribute("usernick", boardService.getNick(updateBoard));
		
		//조회결과 model값 전달
		req.setAttribute("updateBoard", updateBoard);
		
		//첨부파일 정보 view에 전달
		BoardFile boardFile = boardService.viewFile(updateBoard);
		req.setAttribute("boardFile", boardFile);
				
		req.getRequestDispatcher("/WEB-INF/views/board/update.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/board/update [POST]");
		
		boardService.update(req);
		
		resp.sendRedirect("/board/view");
		
		
		
		
	}
	
	

}
