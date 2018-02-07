package com.koitt.board.model.board;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koitt.board.dao.BoardDao;
import com.koitt.board.dao.UsersDao;
import com.koitt.board.model.Command;
import com.koitt.board.vo.Board;
import com.koitt.board.vo.Users;

public class InsertCommand implements Command {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ClassNotFoundException, SQLException {
		// 1. 포워딩할 JSP 페이지명
		String page = "./board/insert-ok.jsp";
		
		// 2. 클라이언트로부터 전달받은 값을 변수에 저장
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String email = req.getParameter("email");
		
		// 2-1. email 값을 이용하여 해당 사용자의 번호를 가져온다.
		UsersDao usersDao = new UsersDao();
		Users users = usersDao.select(email);
		Integer userNo = users.getNo();
		
		// 3. insert로 전달할 Board 객체 생성
		Board board = new Board();
		
		// 4. 2번에서 저장한 변수를 board 객체에 저장
		board.setTitle(title);
		board.setContent(content);
		board.setUserNo(userNo);
		
		// 5. 4번에서 만든 객체를 Dao로 전달하기 위해 BoardDao 객체 생성
		BoardDao dao = new BoardDao();
		
		// 6. INSERT SQL문 실행을 하는 BoardDao의 insert 메소드로 4번 Board 객체 전달
		dao.insert(board);
		
		// 7. 포워딩 할 JSP 페이지를 BoardServlet(Controller)로 전달
		return page;
	}
	
}







