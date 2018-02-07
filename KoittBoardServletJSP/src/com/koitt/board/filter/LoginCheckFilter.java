package com.koitt.board.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/*
 * p.558
 */
public class LoginCheckFilter implements Filter {
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		// 1. HttpServletRequest 관련 메소드를 사용하기 위해 req 객체를 다운캐스팅
		HttpServletRequest httpReq = (HttpServletRequest) req;
		
		/*
		 *  2. 다운캐스팅한 객체에서 getSession 메소드를 사용
		 *  
		 *  파라미터가 false 인 경우
		 *  세션이 존재하지 않으면 null, 세션이 존재하면 존재하는 세션 객체를 리턴
		 *  
		 *  파라미터가 true 인 경우
		 *  세션이 존재하지 않으면 새로운 세션 객체를 리턴
		 *  세션이 존재하면 존재하는 세션 객체를 리턴
		 *  
		 *  파라미터를 false로 지정한 이유는 LoginCommand에서 세션 객체를 만들기 때문에
		 *  필터에서 새로운 세션 객체를 만들면 안되므로 파라미터로 false를 사용
		 */
		HttpSession session = httpReq.getSession(false);
		
		// 로그인 여부를 boolean 타입으로 저장
		boolean login = false;
		
		// 세션 객체가 존재한다면
		if (session != null) {
			// 세션에 "email" key로 접근하여 값이 존재한다면 (로그인 된 상태라면)
			if (session.getAttribute("email") != null) {
				// login 변수의 값을 true로 변경
				login = true;
			}
		}
		
		// 로그인 된 상태라면
		if (login) {
			// 요청한 페이지(로그인해야 접근이 가능한 페이지)로 이동
			chain.doFilter(req, resp);
		
		// 로그인 된 상태가 아니라면
		} else {
			// 로그인 화면으로 이동
			RequestDispatcher dispatcher = req.getRequestDispatcher("/users/login-form.jsp");
			dispatcher.forward(req, resp);
		}
	}
	
	@Override
	public void destroy() {}

}
