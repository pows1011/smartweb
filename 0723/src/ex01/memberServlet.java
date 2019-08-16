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
		while(enu.hasMoreElements()) { // 여기서 member. html의 정보를 받아옴
			String name=enu.nextElement();
			String value=req.getParameter(name);
			out.print(name+":"+value+"<br/>");
		}
		//		out.print("이름:"+username+"</br>");
//		out.print("아이디:"+userid+"</br>");
//		out.print("비밀번호:"+passwd+"</br>");
//		out.print("주소:"+address+"</br>");
//		out.print("이메일:"+email+"</br>");
		out.print("</body></html>");
		out.close();
	}

}
