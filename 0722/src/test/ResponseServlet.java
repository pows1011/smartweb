package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Response")
public class ResponseServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		resp.setCharacterEncoding("EUC-KR");
		PrintWriter out =resp.getWriter();
//		out.write("<HTML><BODY><H1>");
//		out.write("ResponseServlet 夸没己傍");
//		out.write("</H1></BODY></HTML>");
		out.println("ResponseServlet 夸没己傍");
		out.println();
		out.close();
	}
	
	
}
