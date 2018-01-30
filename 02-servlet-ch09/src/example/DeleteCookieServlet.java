package example;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * p.212
 */
public class DeleteCookieServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset = utf-8");
		resp.setCharacterEncoding("utf-8");

		// 클라이언트에 저장된 쿠키배열을 가져온다.
		Cookie[] cookies = req.getCookies();
		if (cookies != null && cookies.length > 0) {
			
			for (int i = 0; i < cookies.length; i++) {
				//key가 name인 쿠키를 찾는다
				if (cookies[i].getName().equals("name")) {
					
					//해당 쿠키값을 지운다
					Cookie cookie = new Cookie("name",null);
					
					//해당 쿠키의 생존기간을 0으로 설정한다.
					cookie.setMaxAge(0);
					
					//다시 클라이언트에게 해당 쿠키를 전달한다.
					resp.addCookie(cookie);
					break;
				}
			}
		}
		PrintWriter out = resp.getWriter();
		out.println("<h1>쿠키를 삭제합니다.</h1>");

		out.flush();
		out.close();
	}
}
