package example;
/*
 * p.208
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MakeCookieServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		resp.setContentType("text/html; charset = utf-8");
		resp.setCharacterEncoding("utf-8");
		
		//"최범균" 문자열을 URL 형식으로 변경하는데 utf-8인코딩을 사용하겠다는 뜻
		String encodeName = URLEncoder.encode("최범균","utf-8");
		
		//쿠키 객체 생성 > name이라는 key에 encodeName 값을 저장
		Cookie cookie = new Cookie("name", encodeName);
		//cookie.setMaxAge(60*60*1000);		//쿠키의 저장기간 설정(1시간동안 저장(초단위))(보안 강화를 위해 설정)
		
		//만든 쿠키를 쿠키목록에 추가
		resp.addCookie(cookie);
		
		PrintWriter out = resp.getWriter();
		out.println(cookie.getName());			//key값 출력
		
		//쿠키의 값을 가져온다.
		out.println("쿠키의 값 =" + cookie.getValue());		//값을 출력
		
		out.flush();
		out.close();
		
	}

}
