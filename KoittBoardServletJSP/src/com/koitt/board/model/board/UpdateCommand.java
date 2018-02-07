package com.koitt.board.model.board;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koitt.board.dao.BoardDao;
import com.koitt.board.model.Command;
import com.koitt.board.vo.Board;

public class UpdateCommand implements Command {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp)
			throws ClassNotFoundException, SQLException, IllegalArgumentException {
		// 1. 포워딩 할 JSP 페이지명
		String page = "./board/update-ok.jsp";
		
		// 2. update-form.jsp로부터 전달받은 no, title, content 값을 전달받아 변수에 저장
		String _no = req.getParameter("no");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		// 3. no값이 없다면 예외발생
		if (_no == null || _no.trim().length() == 0) {
			throw new IllegalArgumentException("게시물 번호가 필요합니다.");
		}
		
		// 4. String 타입의 no값을 Integer 타입으로 변경
		Integer no = Integer.parseInt(_no);
		
		// 5. 수정할 글 번호와 제목, 내용을 담는 Board 객체 생성
		Board board = new Board();
		
		// 6. 수정할 글 번호와 제목, 내용을 객체에 담기
		board.setNo(no);
		board.setTitle(title);
		board.setContent(content);
		
		// 7. 수정하기 위해 dao 객체 생성
		BoardDao dao = new BoardDao();
		
		// 8. 생성한 dao 객체를 이용하여 update SQL문 실행
		dao.update(board);
		
		// 9. BoardServlet(Controller)로 포워딩할 JSP 페이지 주소를 전달
		return page;
	}

}




