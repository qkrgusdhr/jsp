package Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.one")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		int lastSlash = uri.lastIndexOf("/");
		String commandStr = uri.substring(lastSlash);
		
		if(commandStr.equals("/.one"))
			registFunc(request);
		else if(commandStr.equals("/.one"))
			loginFunc(request);
		else if(commandStr.equals("./one"))
			freeboardFunc(request);
		
		request.setAttribute("uri", uri);
		request.setAttribute("commandStr", commandStr);
		
		
	}

	void freeboardFunc(HttpServletRequest request) {
		// TODO Auto-generated method stub
		request.setAttribute("resultValue", "<h4>자유게시판<h4>");
	}

	private void loginFunc(HttpServletRequest request) {
		// TODO Auto-generated method stub
		request.setAttribute("resultValue", "<h4>로그인<h4>");
	}

	void registFunc(HttpServletRequest request) {
		// TODO Auto-generated method stub
		request.setAttribute("resultValue", "<h4>회원가입<h4>");
	}
	
}
