package net.board.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class FontController
 */
@WebServlet("*.do")
public class FontController extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FontController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	String RequestURI=request.getRequestURI();
    	String contextPath=request.getContextPath();
    	String command=RequestURI.substring(contextPath.length());
    	ActionForward forward=null;
    	Action action=null;
    	
    	if(command.equals("/BoardWrite.do")){
    		forward=new ActionForward();
    		forward.setRedirect(false);
    		forward.setPath("/mvc2/board_reply.jsp");
//    	}else if(command.equals("/Replay.do")){
//    		action = new Reply();
//    		try{
//    			forward=action.execute(request, response);
//    		}catch(Exception e){
//    			e.printStackTrace();
//    		}
    	}else if(command.equals("/BoardDelete.do")){
    		forward=new ActionForward();
    		forward.setRedirect(false);
    		forward.setPath("/mvc2/board_delete.jsp");
    		try{
    			forward=action.execute(request, response);
    		}catch(Exception e){
    			e.printStackTrace();
    		}
    	}else if(command.equals("/BoardModify.do")){
    		action = new ModifyView();
    		try{
    			forward=action.execute(request, response);
    		}catch(Exception e){
    			e.printStackTrace();
    		}
    }else if(command.equals("/BoardAddAction.do")){
		action = new Add();
		try{
			forward=action.execute(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
//    }else if(command.equals("/BoardReplyView.do")){
//		action = new ReplyView();
//		try{
//			forward=action.execute(request, response);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
    }else if(command.equals("/BoardModifyAction.do")){
		action = new Modify();
		try{
			forward=action.execute(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
    }else if(command.equals("/BoardDeleteAction.do")){
		action = new Delete();
		try{
			forward=action.execute(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
    }else if(command.equals("/BoardList.do")){
		action = new List();
		try{
			forward=action.execute(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
    }else if(command.equals("/BoardDetailAction.do")){
		action = new Detail();
		try{
			forward=action.execute(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
    }
    	if(forward != null){
    		if(forward.isRedirect()){
    			response.sendRedirect(forward.getPath());
    		}else{
    			RequestDispatcher dispatcher=
    					request.getRequestDispatcher(forward.getPath());
    			dispatcher.forward(request, response);
    		}
    	}
    }
   
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
