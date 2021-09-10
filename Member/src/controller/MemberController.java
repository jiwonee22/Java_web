package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.face.MemberService;
import service.impl.MemberServiceImpl;


@WebServlet("/member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MemberService memberService = new MemberServiceImpl();
	
	
	//회원가입 창 띄우기
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/member [GET]");
		
		//JSP로 응답데이터 만들기 - VIEW 지정하기
		
		RequestDispatcher rd;
		rd = req.getRequestDispatcher("/WEB-INF/views/joinForm.jsp");
		
		rd.forward(req, resp);
		
		
	}
	
	//회원가입 처리하기
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/member [POST]");
		
		//요청 데이터의 한글 인코딩 방식 지정하기
		req.setCharacterEncoding("UTF-8");
				
		//응답 데이터의 형식 지정하기
		resp.setContentType("text/html; charset=utf-8");

	
		
		
		req.getRequestDispatcher("/WEB-INF/views/result.jsp");
		
		
		
		

	
	}
	

}
