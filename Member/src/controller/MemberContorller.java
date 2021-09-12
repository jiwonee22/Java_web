package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dto.Member;
import service.face.MemberService;
import service.impl.MemberServiceImpl;



@WebServlet("/member/join")
public class MemberContorller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MemberService memberService = new MemberServiceImpl();
	
	//회원가입 창 띄우기
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/member/join [GET]");
		
		//JSP로 응답데이터 만들기 - VIEW 지정하기
		
		req.getRequestDispatcher("/WEB-INF/views/joinForm.jsp").forward(req, resp);
	
		
	}
	
	
	//회원가입 처리하기
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("/member/join [POST]");
		
		//요청 데이터의 한글 인코딩 방식 지정하기
		req.setCharacterEncoding("UTF-8");
					
		//응답 데이터의 형식 지정하기
		resp.setContentType("text/html; charset=UTF-8");
		
		//전달 파라미터를 MODEL객체에 저장
		Member param = memberService.getParam(req);
		
		//Member객체를 데이터베이스에 입력
		Member result = memberService.join(param);
		
		//DB에 입력된 값을 View에 전달
		//"result"라는 이름의 result객체를 req에 저장
		req.setAttribute("result", result);
		
		//view를 지정하고 응답하기
		//req객체를 forward를 통해 view에 전달
		req.getRequestDispatcher("/WEB-INF/views/result.jsp").forward(req, resp);
	
	}

}
