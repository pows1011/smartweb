package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/textfield")
public class TextfieldServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
	
		response.setContentType("text/html");
		response.setCharacterEncoding("EUC-KR");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body>");
		out.println("¿Ã∏ß:"+name+"</br>");
		out.println("</body></html>");
		out.println();
		out.close();
	}
	
	
}
