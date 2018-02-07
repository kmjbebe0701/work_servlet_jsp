package com.koitt.board.model.users;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koitt.board.dao.UsersDao;
import com.koitt.board.model.Command;

public class LoginCommand implements Command {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp)
			throws ClassNotFoundException, SQLException {
		
		// 1. 포워딩 할 JSP 페이지명 (로그인 성공 시, 게시판 목록으로 이동)
		String page = "./BoardServlet?cmd=CMD_LIST";
		
		// 2. 이메일과 패스워드를 클라이언트로부터 전달받는다.
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		// 3. 사용자 존재여부와 비밀번호 체크하기 위해 UsersDao 객체를 생성
		UsersDao dao = new UsersDao();
	
		// 4. 이메일과 비밀번호가 일치하면 true, 아니면 false
		boolean matches = dao.matches(email, password);
		
		// 5. 일치한다면 세션에 현재 로그인한 사용자의 이메일을 저장
		if (matches) {
			// 세션에 이메일 값을 저장하기 위해 세션 객체를 가져온다.
			HttpSession session = req.getSession();
			
			/*
			 *  현재 로그인한 사용자의 email값이 세션에 존재한다면
			 *  로그인 된 상태로 간주
			 */
			session.setAttribute("email", email);
			
			// 6. 게시판 목록으로 이동
			return page;
		}
		
		// 7. 일치하는 사용자가 없다면 로그인 페이지에 오류메시지 출력
		return "./users/login-form.jsp?error=matches";
	}

}
