package example.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*
 * p.242
 */
public class SessionLoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		//클라이언트에서 POST방식으로 전달받은 id와 password값을 String변수에 저장한다.
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		
		PrintWriter out = resp.getWriter();
		
		//id와 암호가 같으면 로그인에 성공한 것으로 가정
		if(id.equals(password)) {
			// session객체를 가져온다.
			HttpSession session = req.getSession();
			
			/*
			 * MEMBERID key에 id값을 저장한다.
			 * 쿠키는 addCookie메소드,
			 * 세션에서는 setAttribute를 사용한다.
			 */
			session.setAttribute("MEMBERID", id);
			
			//세션의 유효시간을 지정
			session.setMaxInactiveInterval(10);		//초단위(10초 이내에 접속하면 시간이 늘어남//은행 로그인 생각하기)
			out.println("로그인에 성공했습니다.");
		}
		else {
			out.println("로그인에 실패했습니다.<br>");
			out.println("<a href='../session-login-form.do'>로그인 화면으로 이동</a>");
		}
		
		out.flush();
		out.close();
	}

}
