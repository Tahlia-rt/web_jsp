package net.board.action;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.db.BoardBean;
import net.board.db.BoardDAO;

public class List implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception{
		BoardDAO boarddao=new BoardDAO();
	    ArrayList<BoardDAO> boardlist = new ArrayList<BoardDAO>();
		
		int page = 1;
		int limit =10;
		
		if(request.getParameter("Page")!=null){
			page=Integer.parseInt(request.getParameter("Page"));
		}
		int listcount=boarddao.getListCount();
		boardlist=boarddao.getBoardList(page, limit);
		
		//총 페이지 수
		int maxpage=(int)((double)listcount/limit+0.95); //소수올림처
		int startpage=(((int)((double)page / 10 + 0.9))-1)*10+1;
		int endpage=startpage+10-1;
		
		if(endpage>maxpage) endpage = maxpage;
		
		request.setAttribute("page", page);
		request.setAttribute("maxpage", maxpage);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("listcount", listcount);
		request.setAttribute("boardlist", boardlist);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/mvc2/board_list.jsp");
		
		
		
		return forward;
	}
}
