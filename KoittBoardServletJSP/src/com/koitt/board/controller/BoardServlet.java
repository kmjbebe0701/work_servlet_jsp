package com.koitt.board.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koitt.board.model.Command;
import com.koitt.board.model.ListCommand;

public class BoardServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doProcess(req, resp);
	}
	
	// 클라이언트가 get, post 요청을 하면 doProcess 메소드를 실행하도록 한다.
	private void doProcess(HttpServletRequest req, HttpServletResponse resp) {
		try {
			// 한글 인코딩 처리 (UTF-8 인코딩 설정)
			req.setCharacterEncoding("UTF-8");
			
			// cmd 파라미터 값을 가져온다.
			String cmd = req.getParameter("cmd");
			
			// 만약 cmd값이 없다면 기본으로 게시판 목록 화면으로 이동
			if (cmd == null || cmd.trim().length() == 0) {
				cmd = "CMD_LIST";
			}
			
			// cmd 값에 따라 분기처리
			String page = null;			// 포워딩할 JSP 페이지 명
			Command command = null;		// 비지니스 로직을 처리할 Model 객체
			
			switch (cmd) {
				case "CMD_LIST":
					command = new ListCommand();
					page = command.execute(req, resp);
					break;
			}
			
			// JSP 페이지로 서블릿에서 setAttribute한 내용을 포워딩
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










