package example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginformServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset = utf-8");
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>로그인 폼</title>");
		out.println("</head>");
		out.println("<body>");
		
		//post방식으로 정보 전송
		out.println("<form action ='" + req.getContextPath() + "/member/login.do'" + "method ='post'>");
		out.println("<label>아이디 <input type = 'text' name = 'id' size = '10'></label>");
		out.println("<label>암호 <input type = 'password' name = 'password' size = '10'></label>");
		out.println("<input type = 'submit' value='로그인'>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
	}

}
