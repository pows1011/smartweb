package ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Member")
public class memberServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//		String username=req.getParameter("username");
//		String address=req.getParameter("address");
//		String userid=req.getParameter("userid");
//		String passwd=req.getParameter("passwd");
//		String email=req.getParameter("email");
		req.setCharacterEncoding("EUC-KR");
		Enumeration<String> enu=req.getParameterNames();
		resp.setContentType("text/html; charaset=EUC-KR");
		PrintWriter out=resp.getWriter();
		out.print("<html><body>");
		while(enu.hasMoreElements()) { // ���⼭ member. html�� ������ �޾ƿ�
			String name=enu.nextElement();
			String value=req.getParameter(name);
			out.print(name+":"+value+"<br/>");
		}
		//		out.print("�̸�:"+username+"</br>");
//		out.print("���̵�:"+userid+"</br>");
//		out.print("��й�ȣ:"+passwd+"</br>");
//		out.print("�ּ�:"+address+"</br>");
//		out.print("�̸���:"+email+"</br>");
		out.print("</body></html>");
		out.close();
	}

}
