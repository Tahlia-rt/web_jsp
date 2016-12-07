package net.board.action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.db.*;


public class Modify implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception{
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("UTF-8");
		boolean result=false;
		
		BoardDAO  boarddao = new BoardDAO();
		BoardBean boarddata = new BoardBean();
		
		int num = Integer.parseInt(request.getParameter("B_NUM"));
		
		boolean usercheck = boarddao.isBoardWriter(num, request.getParameter("B_PASS"));
		

		if(usercheck==false){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정할 권한이 없습니다.')");
			out.println("location.href='/BoardList.do'");
			out.println("</script>");
			out.close();
			return null;
		}
		
		try{
			boarddata.setB_SUBJECT(request.getParameter("B_SUBJECT"));
			boarddata.setB_CONTENT(request.getParameter("B_CONTENT"));
			result = boarddao.boardModify(boarddata);
			if(result==false){
				System.out.print("게시판 수정 실패");
			return null;
			}
			System.out.println("게시판 수정 완료");
			
			forward.setRedirect(true);
			forward.setPath("Detail.do?num="+boarddata.getB_NUM());
			return forward;
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;

		
		
		
		
	}
	}