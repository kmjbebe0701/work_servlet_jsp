package com.koitt.book.model;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koitt.book.dao.BookDao;
import com.koitt.book.vo.Book;

public class UpdateCommand implements Command{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp)
			throws ClassNotFoundException, SQLException {
		String page = "./book/update-ok.jsp";
		
		String no = req.getParameter("isbn");
		String title = req.getParameter("title");
		String author = req.getParameter("author");
		String description = req.getParameter("description");
		String _price = req.getParameter("price");
		String publisher = req.getParameter("publisher");
		
		
		if(no == null || no.trim().length() == 0) {
			throw new IllegalArgumentException("게시물 번호가 필요합니다.");
		}
		
		Integer isbn = Integer.parseInt(no);
		Integer price = Integer.parseInt(_price);
		
		Book book = new Book();
		
		book.setAuthor(author);
		book.setDescription(description);
		book.setIsbn(isbn);
		book.setPrice(price);
		book.setPublisher(publisher);
		book.setTitle(title);
		
		BookDao dao = new BookDao();
		dao.update(book);

		
		return page;
	}

}
