package com.koitt.board.model.board;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koitt.board.dao.BoardDao;
import com.koitt.board.model.Command;
import com.koitt.board.vo.Board;

public class ViewCommand implements Command {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp)
			throws ClassNotFoundException, SQLException, IllegalArgumentException, 
			NullPointerException {
		
		// 1. 포워딩 할 JSP 페이지명
		String page = "./board/view.jsp";
		
		// 2. 쿼리문자열로부터 전달받은 글번호 저장
		String _no = req.getParameter("no");
		
		// 3. 전달받은 번호가 null이거나 길이가 0일때
		if (_no == null || _no.trim().length() == 0) {
			// 잘못된 파라미터를 전달했다는 예외를 발생
			throw new IllegalArgumentException("게시물 번호가 필요합니다.");
		}
		
		// 4. String 타입의 파라미터를 Integer 값으로 변경
		Integer no = Integer.parseInt(_no);
		
		// 5. BoardDao를 이용하기 위해 객체 생성
		BoardDao dao = new BoardDao();
		
		// 6. 글 하나를 가져오기 위한 dao의 메소드 호출 (no값 전달)
		Board board = dao.select(no);
		
		// 7. 6번에서 가져온 board객체가 null이라면 예외발생
		if (board == null) {
			throw new NullPointerException("없거나 삭제된 게시물 입니다.");
		}
		
		// 8. request에 attribute 설정 (key: board, value: board객체)
		req.setAttribute("board", board);
		
		// 9. BoardServlet에 포워딩할 JSP 페이지 경로를 전달
		return page;
	}

}






