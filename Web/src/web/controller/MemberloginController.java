package web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dto.Member;
import web.service.face.MemberService;
import web.service.impl.MemberServiceImpl;

@WebServlet("/member/login")
public class MemberloginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	MemberService memberService = new MemberServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/member/login [GET]");

		req.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/member/login [POST]");

		HttpSession session = req.getSession();

		Member member = memberService.getLoginMember(req);
		
		boolean login = memberService.login(member);

		if(login) {
			System.out.println("로그인 성공");
			session.setAttribute("login", true);
			session.setAttribute("loginid", req.getParameter("userid"));
			session.setAttribute("loginick", req.getParameter("usernick"));

			req.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(req, resp);

		} else {
			System.out.println("로그인 실패");
			req.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(req, resp);

		}






	}

}