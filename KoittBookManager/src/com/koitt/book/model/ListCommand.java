package com.koitt.book.model;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koitt.book.dao.BookDao;
import com.koitt.book.vo.Book;

public class ListCommand implements Command{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp)
			throws ClassNotFoundException, SQLException {
		
		String page = "./book/list.jsp";
		
		List<Book> list = null;
		
		BookDao dao = new BookDao();
		list = dao.selectAll();
		
		req.setAttribute("list", list);
		
		return page;
	}

}
