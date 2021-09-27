package login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/login/login [GET]");
		
		req.getRequestDispatcher("/WEB-INF/views/login/loginForm.jsp").forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/login/login [POST]");

		//전달파라미터 얻어오기 - userid, userpw
		String userid = req.getParameter("userid");
		String userpw = req.getParameter("userpw");
		
		System.out.println("userid - " + userid);
		System.out.println("userpw - " + userpw);
		
		HttpSession session = req.getSession();
		
		if("abc".equals(userid) && "123".equals(userpw)) {
			//로그인 성공
			
			System.out.println("LoginController [POST] - 로그인 성공 ");
			
			session.setAttribute("login", true); //로그인 상태
			session.setAttribute("loginid", "abc"); //로그인한 아이디
			
			req.getRequestDispatcher("/WEB-INF/views/login/loginSuccess.jsp").forward(req, resp);
			
		} else {
			//로그인 실패
			
			System.out.println("LoginController [POST] - 로그인 실패");
			req.getRequestDispatcher("/WEB-INF/views/login/loginFail.jsp").forward(req, resp);
		
		}
		
		
		
	}
	
	
}
