package example.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionInfoServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset = utf-8");
		
		// 현재 시간을 가져오기 위해서 생성
		Date time = new Date();
		
		//시간에 특정 형식을 적용하는 객체 생성
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		/*
		 * session객체를 가져옴
		 * 세션은 따로 생성해주는 것이 아니라 클라이언트가 최초로 서버에 접속할 때 자동으로 생성된다.
		 * 만일 클라이언트가 계속 접속된 상태로 getSession을 호출하게 된다면
		 * 최초 접속할 때 사용했던 session객체를 그대로 사용하게 된다.
		 */
		HttpSession session = req.getSession();
		
		PrintWriter out = resp.getWriter();
		
		// getID 메소드 호출하면 현재 세션ID값을 가져온다.
		String sessionId = session.getId();
		out.println("세션ID: " + sessionId + "<br>");
		
		//세션 생성시간을 가져올때에는 getCreationTime 메소드를 호출한다.
		time.setTime(session.getCreationTime());
		out.println("세션생성시간: " + format.format(time) + "<br>");
		
		out.flush();
		out.close();
	}

}
