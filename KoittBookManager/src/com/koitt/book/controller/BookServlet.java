package com.koitt.book.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koitt.book.model.Command;
import com.koitt.book.model.DeleteCommand;
import com.koitt.book.model.InsertCommand;
import com.koitt.book.model.ListCommand;
import com.koitt.book.model.UpdateCommand;
import com.koitt.book.model.UpdateFormCommand;
import com.koitt.book.model.ViewCommand;

public class BookServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doProcess(req, resp);
	}
	
	
	private void doProcess(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.setCharacterEncoding("UTF-8");
			
			String cmd = req.getParameter("cmd");
			
			if(cmd == null || cmd.trim().length() == 0) {
				cmd = "CMD_LIST";
			}
			
			String page = null;
			Command command = null;
			
			switch(cmd) {
				case "CMD_LIST" : 
					command = new ListCommand();
					page = command.execute(req, resp);
					break;
					
				case "CMD_VIEW" : 
					command = new ViewCommand();
					page = command.execute(req, resp);
					break;
					
				case "CMD_INSERT" : 
					command = new InsertCommand();
					page = command.execute(req, resp);
					break;
					
				case "CMD_DELETE" : 
					command = new DeleteCommand();
					page = command.execute(req, resp);
					break;
					
				case "CMD_UPDATE" : 
					command = new UpdateCommand();
					page = command.execute(req, resp);
					break;
					
				case "CMD_UPDATE_FROM" : 
					command = new UpdateFormCommand();
					page = command.execute(req, resp);
					break;
			}
			
			RequestDispatcher rd = req.getRequestDispatcher(page);
			rd.forward(req, resp);
			
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
