package net.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import net.board.db.*;

public class Add implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
	throws Exception{
		BoardDAO boarddao = new BoardDAO();
		BoardBean boarddata = new BoardBean();
		ActionForward forward= new ActionForward();
		
		String realFolder="";
		String saveFolder="boardupload";
		
		int flieSize=5*1024*1024; //5mb
		
		realFolder = request.getRealPath(saveFolder);
		
		boolean result=false;
	
		try{
			MultipartRequest multi=null;
			multi=new MultipartRequest(request, realFolder, flieSize, "UTF-8", new DefaultFileRenamePolicy());
			//중복이름처리에관한 파라미터전달
			
			boarddata.setB_NAME(multi.getParameter("B_NAME"));
			boarddata.setB_PASS(multi.getParameter("B_PASS"));
			boarddata.setB_SUBJECT(multi.getParameter("B_SUBJECT"));
			boarddata.setB_CONTENT(multi.getParameter("B_CONTENT"));
			boarddata.setB_FILE(multi.getFilesystemName((String)multi.getFileNames().nextElement()));
			
			result=boarddao.boardInsert(boarddata);
			
			if(result==false){
				System.out.println("게시판 등록 실패");
			}
			System.out.println("게시판 등록 완료!!");
			
			forward.setRedirect(true);
			forward.setPath("/board_list.do");return forward;
			
			
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
		
	}
	
	

}
