package mvcboard;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.JSFunction;

import java.io.IOException;

import fileupload.FileUtil;

/**
 * Servlet implementation class WriteController
 */
public class WriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/14MVCBoard/Write.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String saveDirectory = request.getServletContext().getRealPath("/Uploads");
		
		String originalFileName = "";
		try {
			originalFileName = FileUtil.uploadFile(request, saveDirectory);
		}catch (Exception e) {
			// TODO: handle exception
			JSFunction.alertLocation(response, "파일 업로드 오류입니다.", "../mvcboard/write.do");
			return;
		}
		
		MVCBoardDTO dto = new MVCBoardDTO();
		dto.setName(request.getParameter("name"));
		dto.setTitle(request.getParameter("title"));
		dto.setContent(request.getParameter("content"));
		dto.setPass(request.getParameter("pass"));
		
		if(originalFileName != "") {
			String savedFileName = FileUtil.renameFile(saveDirectory, originalFileName);
			dto.setOfile(originalFileName);
			dto.setSfile(savedFileName);
		}
		MVCBoardDAO dao = new MVCBoardDAO();
		int result = dao.insertWrite(dto);
		dao.close();
		
		if(result == 1) {
			response.sendRedirect("../mvcboard/list.do");
		}else {
			JSFunction.alertLocation(response, "글쓰기에 실패했습니다.", "../mvcboard/write.do");
		}
	}

}
