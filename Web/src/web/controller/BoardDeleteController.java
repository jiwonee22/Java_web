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

@WebServlet("/board/delete")
public class BoardDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardService boardService = new BoardServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/board/delete [GET]");

		Board boardno = boardService.getBoardno(req);

		Board viewBoard = boardService.view(boardno);

		req.setAttribute("viewBoard", viewBoard);

		BoardFile boardFile = boardService.viewFile(viewBoard);

		req.setAttribute("boardFile", boardFile);

		req.getRequestDispatcher("/WEB-INF/views/board/delete.jsp").forward(req, resp);


	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/board/delete [POST]");
		
		Board deleteBoard = new Board();
		
//		boardService.delete(deleteBoard);
		
		resp.sendRedirect("/board/list");
	}

}
