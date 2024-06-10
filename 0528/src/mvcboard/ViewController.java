package mvcboard;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Servlet implementation class ViewController
 */
@WebServlet("/mvcboard/view.do")
public class ViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MVCBoardDAO dao = new MVCBoardDAO();
		String idx = request.getParameter("idx");
		dao.UpdateVisitCount(idx);
		MVCBoardDTO dto = dao.selectView(idx);
		dao.close();
		
		dto.setContent(dto.getContent().replaceAll("\r\n", "<br/>"));
		
		String ext = null, fileName = dto.getSfile();
		if(fileName != null) {
			ext = fileName.substring(fileName.lastIndexOf(".")+1);
		}
		String[] mimeStr = {"png", "jpg", "gif"};
		List<String> mimeList = Arrays.asList(mimeStr);
		boolean isImage = false;
		if(mimeList.contains(ext)) {
			isImage = true;
		}
		
		request.setAttribute("dto", dto);
		request.setAttribute("isImage", isImage);
		request.getRequestDispatcher("/14MVCBoard/View.jsp").forward(request, response);
	}

}
