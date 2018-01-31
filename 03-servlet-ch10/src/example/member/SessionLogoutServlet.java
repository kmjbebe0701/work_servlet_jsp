package example.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionLogoutServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset = utf-8");
		
		/*
		 * 1. 전체 삭제하는 방법
		 */
		HttpSession session = req.getSession();
		//session.invalidate();
		
		/*
		 * 2.부분 삭제하는방법
		 */
		session.removeAttribute("MEMBERID");
		
		PrintWriter out = resp.getWriter();
		out.println("로그아웃하였습니다.");
		
		out.flush();
		out.close();
		
		
		
	}

}
