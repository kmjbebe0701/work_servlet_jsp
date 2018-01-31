package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.CookieHelper;

/*
 * p.560
 */
public class LoginServlet extends HttpServlet {
	/*
	 * doPost: 클라이언트가 HTTP Method POST로 요청을 하면 doPost메소드가 실행된다.
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset = utf-8");

		
		String id = req.getParameter("id");
		HttpSession session = req.getSession();
		session.setAttribute("MEMBER", id);

		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><title>로그인</title></head>");
		out.println("<body>");
		out.println("로그인처리");
		out.println("</body>");
		out.println("</html>");

		out.flush();
		out.close();

	}

}
