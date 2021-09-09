package hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello") //등록 + url지정
//자동으로 서블릿클래스에 등록해주는 annotation
public class HelloServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/hello [GET]");
		
		//응답 데이터의 형식을 지정한다 (HTML 형식)
		resp.setContentType("text/html; charset=UTF-8");
		
		//응답용 출력 스트림d
		PrintWriter out = resp.getWriter();
		
		//응답 내용 작성 및 출력 - HTML형식으로 작성한다
		out.append("<h1>하이하이</h1>");
		out.append("<h3>잘되는지 확인</h3>");
	}
	
}
