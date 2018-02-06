package com.koitt.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.koitt.book.util.DBUtil;
import com.koitt.book.vo.Book;

public class BookDao {

	public List<Book> selectAll() throws ClassNotFoundException, SQLException {

		Connection conn = DBUtil.getInstance().getConnection();

		String sql = "SELECT * FROM book";

		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();

		List<Book> list = new ArrayList<>();
		while (rs.next()) {
			Book book = new Book();

			book.setIsbn(rs.getInt("isbn"));
			book.setTitle(rs.getString("title"));
			book.setPublisher(rs.getString("publisher"));
			book.setAuthor(rs.getString("author"));
			book.setPrice(rs.getInt("price"));
			book.setDescription(rs.getString("description"));

			list.add(book);
		}

		DBUtil.getInstance().close(rs);
		DBUtil.getInstance().close(pstm);
		DBUtil.getInstance().close(conn);

		return list;
	}

	public Book select(Integer isbn) throws ClassNotFoundException, SQLException {

		Connection conn = DBUtil.getInstance().getConnection();
		String sql = "SELECT * FROM book WHERE isbn = ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, isbn);

		ResultSet rs = pstm.executeQuery();

		rs.next();
		Book book = new Book();
		book.setIsbn(rs.getInt("isbn"));
		book.setAuthor(rs.getString("author"));
		book.setDescription(rs.getString("description"));
		book.setPrice(rs.getInt("price"));
		book.setPublisher(rs.getString("publisher"));
		book.setTitle(rs.getString("title"));

		DBUtil.getInstance().close(rs);
		DBUtil.getInstance().close(pstm);
		DBUtil.getInstance().close(conn);

		return book;
	}

	public void insert(Book book) throws ClassNotFoundException, SQLException {
		
		Connection conn = DBUtil.getInstance().getConnection();
		String sql = "INSERT INTO Book (title, author, publisher, price, description)" + 
				"VALUES (?, ?, ?, ?, ?);";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, book.getTitle());
		pstm.setString(2, book.getAuthor());
		pstm.setString(3, book.getPublisher());
		pstm.setInt(4, book.getPrice());
		pstm.setString(5, book.getDescription());
		
		pstm.executeUpdate();
		
		DBUtil.getInstance().close(pstm);
		DBUtil.getInstance().close(conn);

	}

	public void delete(Integer isbn) throws ClassNotFoundException, SQLException {
		Connection conn = DBUtil.getInstance().getConnection();
		String sql = "DELETE FROM book WHERE isbn = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, isbn);
		
		pstm.executeUpdate();
		
		DBUtil.getInstance().close(pstm);
		DBUtil.getInstance().close(conn);

	}

	public void update(Book book) throws ClassNotFoundException, SQLException {
		
		Connection conn = DBUtil.getInstance().getConnection();
		String sql = "UPDATE book SET title = ?, author = ?, publisher = ?, price = ?, description = ? "
				  + "WHERE isbn =?";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, book.getTitle());
		pstm.setString(2, book.getAuthor());
		pstm.setString(3, book.getPublisher());
		pstm.setInt(4, book.getPrice());
		pstm.setString(5, book.getDescription());
		pstm.setInt(6, book.getIsbn());
		
		pstm.executeUpdate();

		DBUtil.getInstance().close(pstm);
		DBUtil.getInstance().close(conn);
	}

}
