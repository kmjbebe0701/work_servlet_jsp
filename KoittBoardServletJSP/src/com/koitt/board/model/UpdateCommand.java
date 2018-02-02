package com.koitt.board.model;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koitt.board.dao.BoardDao;
import com.koitt.board.vo.Board;

public class UpdateCommand implements Command{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp)
			throws ClassNotFoundException, SQLException, IllegalArgumentException {
		// 1. 포워딩할 JSP 페이지명
		String page = "./board/update-ok.jsp";
		
		String _no = req.getParameter("no");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		if(_no == null || _no.trim().length() == 0) {
			throw new IllegalArgumentException("게시물 번호가 필요합니다.");
		}
		Integer no = Integer.parseInt(_no);
		
		Board board = new Board();
		board.setNo(no);
		board.setTitle(title);
		board.setContent(content);
		
		BoardDao dao = new BoardDao();
		dao.update(board);
		
		return page;
	}

}
