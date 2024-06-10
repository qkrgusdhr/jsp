package utils;


import java.io.PrintWriter;


import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.jsp.JspWriter;

public class JSFunction {
	public static void alertLocation(HttpServletResponse response, String url, String string) {
		try {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = response.getWriter();
			String script = ""
						  + "<script>"
						  + "	alert('" + response +"');"
						  + "	location.href = '" + url +"';"
						  + "</script>";
			writer.print(script);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void alertBack(HttpServletResponse response, String msg, JspWriter out) {
		try {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = response.getWriter();
			String script = ""
						  + "<script>"
						  + " 	alert('" + msg + "');"
						  + " 	history.back();"
						  +	"</script>";
			writer.print(script);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}
