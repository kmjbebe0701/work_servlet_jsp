package com.koitt.book.model;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koitt.book.dao.BookDao;

public class DeleteCommand implements Command {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp)
			throws ClassNotFoundException, SQLException {
		String page = "./book/delete.jsp";

		String no = req.getParameter("isbn");

		
		if (no == null || no.trim().length() == 0) {
			throw new IllegalArgumentException("게시물 번호가 필요합니다.");
		}

		
		Integer isbn = Integer.parseInt(no);

		
		BookDao dao = new BookDao();

		dao.delete(isbn);

		return page;
	}

}
