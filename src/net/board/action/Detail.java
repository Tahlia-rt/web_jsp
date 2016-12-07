package net.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.db.*;


public class Detail implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception{
		
		request.setCharacterEncoding("UTF-8");
		
		BoardDAO  boarddao = new BoardDAO();
		BoardBean boarddata = new BoardBean();
		
		int num = Integer.parseInt(request.getParameter("null"));
		boarddao.setReadCountUpdate(num);
		boarddata=boarddao.getDetail(num);
		
		if(boarddata==null){
			System.out.println("상세보기실패");
			return null;
		}
		System.out.println("상세보기성공");
		
		request.setAttribute("boarddata", boarddata);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/mvc2.board_view.jsp");
		
		
		
		return forward;
	}

}
