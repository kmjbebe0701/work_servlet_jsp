package example.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionLoginCheckServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset = utf-8");
		
		PrintWriter out = resp.getWriter();
		
		//세션 객체를 getSession()메소드를 호출해서 가져온다
		HttpSession session = req.getSession();
		
		/*
		 * getAttribute 메소드를 이용하여 key를 이용해 해당 값을 가져온다.
		 * getAttribute는 리턴타입이 Object이므로 다운캐스팅 해야한다.
		 */
		Object obj = session.getAttribute("MEMBERID");
		String memberId = null;
		if (obj instanceof String) {		//실제 저장된 MEMBERID값이 String타입인지 확인
			memberId = (String) session.getAttribute("MEMBERID");
		}
		
		//삼항 연산자를 이용해서 memberId값이 null이면 로그인이 안된 상태로 판단한다.
		boolean isLogin = memberId ==null? false : true;
		if(isLogin) {
			out.println("아이디 '" + memberId + "'로 로그인 한 상태<br>");
			out.println("<a href='session-logout.do'>로그아웃</a>");
		}
		else {
			out.println("로그인 하지 않은 상태");
		}
		
		out.flush();
		out.close();
		
		
	}

}
