package webshop.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webshop.model.BoardDAO;
import webshop.model.BoardDTO;

public class BoardController extends HttpServlet {
	
	private static final long serialVersionUID=1L;
	static final int LISTCOUNT = 5;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String RequestURI=req.getRequestURI();
		String contextPath=req.getContextPath();
		String command=RequestURI.substring(contextPath.length());
		System.out.println("URL체크 : "+command);
		
		resp.setContentType("text/html; charset=utf-8");
		req.setCharacterEncoding("utf-8");
		
		if(command.equals("/webshop/BoardListAction.do")) {
			System.out.println("if문 안쪽");
			requestBoardList(req);
			RequestDispatcher rd = req.getRequestDispatcher("/webshop/list.jsp");
			rd.forward(req, resp);
		}else if (command.equals("/webshop/BoardWriteForm.do")) { 
			System.out.println("if문 안쪽");
			requestLoginName(req);
			RequestDispatcher rd = req.getRequestDispatcher("/webshop/writeForm.jsp");
			rd.forward(req, resp);	
		}else if (command.equals("/webshop/BoardWriteAction.do")) {
			requestBoardWrite(req);
			RequestDispatcher rd = req.getRequestDispatcher("/webshop/BoardListAction.do");
			rd.forward(req, resp);						
		}else if (command.equals("/webshop/BoardViewAction.do")) {
			requestBoardView(req);
			RequestDispatcher rd = req.getRequestDispatcher("/webshop/BoardView.do");
			rd.forward(req, resp);						
		}else if (command.equals("/webshop/BoardView.do")) { 
			RequestDispatcher rd = req.getRequestDispatcher("/webshop/view.jsp");
			rd.forward(req, resp);	
		}else if (command.equals("/webshop/BoardUpdateAction.do")) {
			requestBoardUpdate(req);
			RequestDispatcher rd = req.getRequestDispatcher("/webshop/BoardListAction.do");
			rd.forward(req, resp);
		}else if (command.equals("/webshop/BoardDeleteAction.do")) { 
			requestBoardDelete(req);
			RequestDispatcher rd = req.getRequestDispatcher("/webshop/BoardListAction.do");
			rd.forward(req, resp);				
		} 
	}
	
	public void requestBoardList(HttpServletRequest request) {
		BoardDAO dao = BoardDAO.getInstance();
		List<BoardDTO> boardlist = new ArrayList<BoardDTO>();
		
	  	int pageNum=1;
		int limit=LISTCOUNT;
		
		if(request.getParameter("pageNum")!=null)
			pageNum=Integer.parseInt(request.getParameter("pageNum"));
				
		String items = request.getParameter("items");
		String text = request.getParameter("text");
		
		int total_record=dao.getListCount(items, text);
		boardlist = dao.getBoardList(pageNum,limit, items, text); 
		
		int total_page;
		
		if (total_record % limit == 0){     
	     	total_page =total_record/limit;
	     	Math.floor(total_page);  
		}
		else{
		   total_page =total_record/limit;
		   Math.floor(total_page); 
		   total_page =  total_page + 1; 
		}		
   
   		request.setAttribute("pageNum", pageNum);		  
   		request.setAttribute("total_page", total_page);   
		request.setAttribute("total_record",total_record); 
		request.setAttribute("boardlist", boardlist);								
	}
	
	public void requestLoginName(HttpServletRequest request){
		System.out.println("requestLoginName");			
		String id = request.getParameter("id");
		BoardDAO  dao = BoardDAO.getInstance();
		String name = dao.getLoginNameById(id);		
		request.setAttribute("name", name);	
	}
	
	public void requestBoardWrite(HttpServletRequest request){
		
		BoardDAO dao = BoardDAO.getInstance();		
		
		BoardDTO board = new BoardDTO();
		board.setId(request.getParameter("id"));
		board.setName(request.getParameter("name"));
		board.setSubject(request.getParameter("subject"));
		board.setContent(request.getParameter("content"));	
		
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("subject"));
		System.out.println(request.getParameter("content"));
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy/MM/dd(HH:mm:ss)");
		String regist_day = formatter.format(new java.util.Date()); 
		
		board.setHit(0);
		board.setRegist_day(regist_day);
		board.setIp(request.getRemoteAddr());			
		
		dao.insertBoard(board);								
	}
	
	public void requestBoardView(HttpServletRequest request){
		
		BoardDAO dao = BoardDAO.getInstance();
		int num = Integer.parseInt(request.getParameter("num"));
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));	
		
		BoardDTO board = new BoardDTO();
		board = dao.getBoardByNum(num, pageNum);		
		
		request.setAttribute("num", num);		 
   		request.setAttribute("page", pageNum); 
   		request.setAttribute("board", board);   									
	}
	
	public void requestBoardUpdate(HttpServletRequest request){
		
		int num = Integer.parseInt(request.getParameter("num"));
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));	
		
		BoardDAO dao = BoardDAO.getInstance();		
		
		BoardDTO board = new BoardDTO();		
		board.setNum(num);
		board.setName(request.getParameter("name"));
		board.setSubject(request.getParameter("subject"));
		board.setContent(request.getParameter("content"));		
		
		 java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy/MM/dd(HH:mm:ss)");
		 String regist_day = formatter.format(new java.util.Date()); 
		 
		 board.setHit(0);
		 board.setRegist_day(regist_day);
		 board.setIp(request.getRemoteAddr());			
		
		 dao.updateBoard(board);								
	}
	
	public void requestBoardDelete(HttpServletRequest request){
		
		int num = Integer.parseInt(request.getParameter("num"));
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));	
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.deleteBoard(num);							
	}
	
}









