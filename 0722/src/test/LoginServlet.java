package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userid=req.getParameter("userid");
		String passwd=req.getParameter("passwd");
		
		resp.setContentType("text/html");
		resp.setCharacterEncoding("EUC-KR");
		PrintWriter out =resp.getWriter();
	
		out.print("<html><body>");
		out.print("ID:"+userid+"</br>");
		out.print("Password:"+passwd);
		out.print("</html></body>");
		out.close();
	}
	
	
}
