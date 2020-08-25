package exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//응답 결과에 대한 설명
		response.setContentType("text/html;charset=UTF-8");
		//응답 결과 작성 통로
		//getWriter()는 PrintWriter 객체를 return
		PrintWriter out = response.getWriter();
		//h1태그 : 크게 보이게 함
		out.print("<h1>Hello servlet</h1>");
		
		/*
		 * run on server
		 * 이클립스는 내부적으로 톰캣을 실행
		 * 클라이언트에서 get method로 서블릿을 가리키는 url을 이용해 요청
		 * was가 서블릿 내 doGet() 실행
		 * response 객체에 hello servlet 넣음
		 * 클라이언트가 그 결과를 받아 출력
		 * 
		 */
		
		//test
	}

}
