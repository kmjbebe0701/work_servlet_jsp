package com.koitt.board.model.users;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koitt.board.dao.UsersDao;
import com.koitt.board.model.Command;
import com.koitt.board.vo.Users;

public class ListCommand implements Command {
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp)
			throws ClassNotFoundException, SQLException {
		String page = "./users/list.jsp";
		
		List<Users> list = null;
		UsersDao dao = new UsersDao();
		list = dao.selectAll();
		
		req.setAttribute("list", list);
		
		return page;
	}
}
