package example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.CookieHelper;

public class LoginServlet extends HttpServlet{
	/*
	 *doPost: 클라이언트가 HTTP Method POST로 요청을 하면 doPost메소드가 실행된다.
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset = utf-8");
		
		/*
		 * 클라이언트로부터 전달받은 요청 주문서에서 body부분을 확인하여 id값과 password값을
		 * getParameter메소드를 이용하여 가져온다.
		 */
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		
		PrintWriter out = resp.getWriter();
		
		//id 와 암호가 같으면 로그인에 성공한 것으로 가정
		if(id.equals(password)) {
			/*
			 *  AUTH key에 id값을 저장한다. path가 "/"이하에서만 접근이 가능하다.
			 *  maxAge를 -1로 저장한것은 AUTH 쿠키를 무기한으로 웹브라우저에 저장하기 위해서이다.
			 */
			resp.addCookie(CookieHelper.createCookie("AUTH", id, "/", -1));
			out.println("로그인에 성공했습니다.");
		}
		else {
			out.println("로그인에 실패했습니다.<br>");
			
			/*
			 * anchor 태그로 페이지 이동 가능하다(하이퍼링크 생성)
			 * 상대경로: ".."(바로 위 부모 경로로 이동)
			 */
			out.println("<a href='../login-form.do'> 로그인 화면으로 이동</a>");
		}
		out.flush();
		out.close();
		
	}

}
