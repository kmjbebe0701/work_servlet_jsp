package com.koitt.book.model;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koitt.book.dao.BookDao;
import com.koitt.book.vo.Book;



public class UpdateFormCommand implements Command{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp)
			throws ClassNotFoundException, SQLException, IllegalArgumentException, NullPointerException {
		
		String page = "./book/update-form.jsp";
		
		String no = req.getParameter("isbn");
		
		if(no == null || no.trim().length() == 0) {
			throw new IllegalArgumentException("게시물 번호가 필요합니다.");
		}
		
		Integer isbn = Integer.parseInt(no);
		
		BookDao dao = new  BookDao();
		
		Book book = dao.select(isbn);
		
		if(book ==null) {
			throw new NullPointerException("없거나 삭제된 게시물입니다.");
		}
		
		req.setAttribute("book", book);
		
		return page;
	}

}
