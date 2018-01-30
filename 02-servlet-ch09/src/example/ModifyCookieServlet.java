package example;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
/*
 * p.211
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ModifyCookieServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset = utf-8");
		
		//클라이언트에 저장된 쿠키배열을 가져온다.
		Cookie[] cookies = req.getCookies();
		
		//쿠키 존재여부 체크
		if (cookies != null && cookies.length>0) {
			//for문을 이용해 찾는 key가 있는지 찾고 새로 쿠키를 입력한다(입력 시 자동 덮어쓰기)
			for ( int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("name")) {
					Cookie cookie = new Cookie("name", URLEncoder.encode("JSP프로그래밍", "utf-8"));
					resp.addCookie(cookie);
					break;
				}
			}
		}
		PrintWriter out = resp.getWriter();
		out.println("<h1>쿠키의 값을 변경합니다</h1>");
		
		out.flush();
		out.close();
	}

}
