package example;
/*
 * p.503
 */

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 방법2: 애노테이션(annotation)을 이용하여 URL과 Servlet을 연결
 * 장점: 따로 Deployment Descriptor(web.xml)를 작성하지 않아도 된다.
 * 단점: URL값이 코드 내부에 있어서 주소가 변경되면 컴파일을 다시 해야한다.
 */
@WebServlet(urlPatterns = "/hello")
public class HelloServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		//클라이언트로 전달받은 내용을  utf-8 인코딩을  이용해 읽는다.
		req.setCharacterEncoding("utf-8");
		
		resp.setContentType("text/html; charset = utf-8");
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><title>인사</title></head>");
		out.println("<body>");
		out.println("안녕하세요,");
		
		//쿼리 문자열에서 name의 값을 가져와서 사용
		out.println(req.getParameter("name"));
		out.println("("+req.getParameter("age")+")");
		out.println("님");
		out.println("</body></html>");
		
		out.flush();
		out.close();
		
	}

}
