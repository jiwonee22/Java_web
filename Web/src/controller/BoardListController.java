package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Board;
import service.face.BoardService;
import service.impl.BoardServiceImpl;


@WebServlet("/board/list")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//서비스 객체
	private BoardService boardService = new BoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/board/list [GET]");
		
		//게시글 정보 전체 조회하기
		List<Board> list = boardService.getList();
		
		//조회결과를 모델값으로 전달하기
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(req, resp);
		
		
		
	}
	

	
	

}
