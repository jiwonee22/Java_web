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
		
		Board boardno = boardService.getBoardno(req);
		
		Board updateBoard = boardService.view(boardno);
		
		req.setAttribute("viewBoard", updateBoard);
		
		BoardFile boardFile = boardService.viewFile(updateBoard);
		
		req.setAttribute("boardFile", boardFile);
				
		req.getRequestDispatcher("/WEB-INF/views/board/update.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/board/update [POST]");
		
		Board updateBoard = new Board();
		
		boardService.update(updateBoard);
		
		req.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(req, resp);
	
		
		
		
		
	}
	
	

}
