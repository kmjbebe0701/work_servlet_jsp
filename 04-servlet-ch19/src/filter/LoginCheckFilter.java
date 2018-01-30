package filter;

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
 * 로그인이 필요한 특정경로로 바로 접속했을 결우 로그인이 안된 상태로 접속시, 
 * 로그인 페이지를 출력하도록 해주는 필터
 */
public class LoginCheckFilter implements Filter{


	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) 
			throws IOException, ServletException {
		
		//HttpServletRequest의 기능을 사용하기 위한 다운캐스팅 (getSession 메소드)
		HttpServletRequest httpReq = (HttpServletRequest) req;
		
		//getSession(false): 현재 세션이 존재하면 세션 객체를 리턴, 아니면 null 값 리턴
		//getSession(true): 현재 세션이 존재하면 세션 객체를 리턴, 아니면 새로 세션을 생성하여 리턴
		HttpSession session = httpReq.getSession(false);
		
		//로그인 여부를 판단하는 boolean 변수
		boolean login = false;
		
		//세션이 존재하면
		if(session != null) {
			//MEMBER key에 해당하는 값이 존재한다면 로그인 된 상태이므로 login값을 true로 설정
			if(session.getAttribute("MEMBER") != null) {
				login = true;
			}
		}
		
		//로그인 된 상태라면
		if(login) {
			//doFilter 호출 전은 클라이언트로부터 요청이 들어오는 방향
			chain.doFilter(req, resp);
			//doFilter 호출 후는 서버로부터 클라이언트로 응답이 나가는 방향
			System.out.println("필터 처리 끝난 후 서버의 응답이 빠져나감");
		}
		else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/loginForm.jsp");
			dispatcher.forward(req, resp);
		}
	}

	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
