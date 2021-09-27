package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException { 
		//필터에서 필터로, 필터에서 서블릿으로 요청처리를 넘겨줄때 doFilter메소드를 작성
		//Encodingfilter클래스에서 메소드를 작성한 후, 서블릿으로 요청을 넘겨줄것!!
		
		System.out.println("EncodingFilter - doFilter()");
		
		System.out.println("--- 컨트롤러 동작 전 ---");
		
		//요청 정보에 대한 한글 인코딩 설정
		request.setCharacterEncoding("UTF-8");
		
		
		//요청정보를 컨트롤러로 전달한다
		// FilterChain을 이용한 doFilter()를 호출하지 않으면 서블릿클래스로 요청이 전달되지 않는다
		chain.doFilter(request, response);
		
		System.out.println("--- 컨트롤러 동작 후 ---");
		
	}

}
