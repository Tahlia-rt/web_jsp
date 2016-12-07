package net.board.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
Connection con;
PreparedStatement pstmt;
ResultSet rs;

  public BoardDAO(){
	  try{
		  Context init = new InitialContext();
		  DataSource ds=
				  (DataSource)init.lookup("java:comp/env/jdbc/MySql");
		  con = ds.getConnection();
		  
  }catch(Exception ex){
	  System.out.println("DB연결실"+ex);
	  return;
  }
}
  
  //글의 개수 get list count
  public int getListCount(){
	  int x=0;
	  try{
		  pstmt = con.prepareStatement("SELECT COUNT(*) FROM HYEJIN.BOARD");
		  rs = pstmt.executeQuery();
		  if(rs.next()){
			  x=rs.getInt(1);
		  }
		  
	  }catch(Exception ex){
		  System.out.println("getListCount error"+ex);
		  
	  }finally{
		  if(rs!=null)try{rs.close();}catch(SQLException ex){}
		  if(pstmt!=null)try{pstmt.close();}catch(SQLException ex){}
	  }
	  return x;
	  
  }
  
 
  //글 목록 get board list (ArrayList)
 public ArrayList<BoardDAO> getBoardList(int page, int limit){
	 String board_list_sql="SELECT B_NUM, B_NAME, B_SUBJECT, B_CONTENT, B_FILE, B_RE_REF, B_RE_LEV, B_RE_SEQ, B_READCOUNT, R_DATE FROM HYEJIN.BOARD";
	 /*rownum = 출력되는 행번호 자동으로 생성해줌
	  * where 뒤 = orderby는 가장 마지막으로 실행돼서.
	  * 
	 */
	 
	 
	 ArrayList<BoarBean> list = new ArrayList<BoardBean>();
	 
	 int startrow = (page-1)*10+1; //읽기시작
     int endrow = startrow+limit-1; //읽기 마지막
     try{
    	 pstmt = con.prepareStatement(board_list_sql);
    	 pstmt.setInt(1, startrow);
    	 pstmt.setInt(2, endrow);
    	 rs = pstmt.executeQuery();
    	 
    	 while(rs.next()){
    		 BoardBean board = new BoardBean();
    		 board.setB_NUM(rs.getInt("B_NUM"));
    		 board.setB_NAME(rs.getString("B_NAME"));
    		 board.setB_SUBJECT(rs.getString("B_SUBJECT"));
    		 board.setB_CONTENT(rs.getString("B_CONTENT"));
    		 board.setB_FILE(rs.getString("B_FILE"));
    		 board.setB_RE_REF(rs.getInt("B_REF"));
    		 board.setB_RE_LEV(rs.getInt("B_LEV"));
    		 board.setB_RE_SEQ(rs.getInt("B_SEQ"));
    		 board.setB_READCOUNT(rs.getInt("B_READCOUNT"));
    		 board.setB_DATE(rs.getDate("B_DATE"));
    		 list.add(board);
        	 }
    	 return list;
    	 
     }catch(Exception ex){
    	 System.out.println("getBoardList error"+ex);
    	 
     }finally{
    	  if(rs!=null)try{rs.close();}catch(SQLException ex){}
		  if(pstmt!=null)try{pstmt.close();}catch(SQLException ex){}
     }
	 return null;
	 
 }
 
 //글내용보기  get Detail
 public BoardBean getDetail(int num) throws Exception{
	 BoardBean board = null;
	 
	 try{
		 pstmt = con.prepareStatement("SELECT * FROM HYEJIN.BOARD WHERE B_NUM = ?");
		 pstmt.setInt(1, num);
		 rs=pstmt.executeQuery();
		 if(rs.next()){
			 board = new BoardBean();
			 board.setB_NUM(rs.getInt("B_NUM"));
    		 board.setB_NAME(rs.getString("B_NAME"));
    		 board.setB_SUBJECT(rs.getString("B_SUBJECT"));
    		 board.setB_CONTENT(rs.getString("B_CONTENT"));
    		 board.setB_FILE(rs.getString("B_FILE"));
    		 board.setB_RE_REF(rs.getInt("B_REF"));
    		 board.setB_RE_LEV(rs.getInt("B_LEV"));
    		 board.setB_RE_SEQ(rs.getInt("B_SEQ"));
    		 board.setB_READCOUNT(rs.getInt("B_READCOUNT"));
    		 board.setB_DATE(rs.getDate("B_DATE"));
			 
		 }
		 
		return board;
		 
	 }catch(Exception ex){
    	 System.out.println("getDetail error"+ex);

	 }finally{
		  if(rs!=null)try{rs.close();}catch(SQLException ex){}
		  if(pstmt!=null)try{pstmt.close();}catch(SQLException ex){}
	 }
	 
	 
	 return null;
 }
 
  //글등록
 public boolean boardInsert(BoardBean board){
	 int num=0; //reply num
	 String sql="";
	 int result=0;
	 
	 try{
		 pstmt=con.prepareStatement("SELECT MAX(bard_num) FROM HYEJIN.BOARD");
		 rs = pstmt.executeQuery();
		 if(rs.next()){
			 num = rs.getInt(1)+1;
		 }else{
			 num=1;
		 }
	sql="INSERT INTO HYEJIN.BOARD(B_NUM=?, B_NAME=?, B_PASS=?, B_SUBJECT=?,";
	sql+="B_CONTENT=?, B_FILE=?, B_RE_REF=?, B_RE_LEV=?,B_RE_SEQ=?, B_READCOUNT=?, R_DATE=sysdate)";
	
	pstmt = con.prepareStatement(sql);
	pstmt.setInt(1, num);
	pstmt.setString(2, board.getB_NAME());
	pstmt.setString(3, board.getB_PASS());
	pstmt.setString(4, board.getB_SUBJECT());
	pstmt.setString(5, board.getB_CONTENT());
	pstmt.setString(6, board.getB_FILE());
	pstmt.setInt(7, num);
	pstmt.setInt(8, 0);
	pstmt.setInt(9, 0);
	pstmt.setInt(10, 0);
	
	result=pstmt.executeUpdate();
	if(result==0){
		return false;
	}
	
	return true;
			
	 }catch(Exception ex){
    	 System.out.println("board Insert error"+ex);
		 
	 }finally{
		  if(rs!=null)try{rs.close();}catch(SQLException ex){}
		  if(pstmt!=null)try{pstmt.close();}catch(SQLException ex){}
	 }
	 
	 return false;
	 
 }
 //글답변
// public String boardReply(){
//	 
//	  String board_max_sql="SELECT MAX(board_num) FROM HYEJIN.BOARD";
//	  String sql="";
//	  int result=0;
//	  
//	  int re_ref=board.getB_RE_REF();
//	  int re_lev=board.getB_RE_LEV();
//	 
//	 System.out.println("준비중 입니다.");
//	return null;
// }
 //글수정
  public boolean boardModify(BoardBean modifyboard) throws Exception{
	  String sql="UPDATE HYEJIN.BOARD SET B_SUBJECT=?, B_CONTENT=? WHERE B_NUM=?";
	  try{
		  pstmt=con.prepareStatement(sql);
		  pstmt.setString(1, modifyboard.getB_SUBJECT());
		  pstmt.setString(2, modifyboard.getB_CONTENT());
		  pstmt.setInt(3, modifyboard.getB_NUM());
		  pstmt.executeUpdate();
		  return true;
		  
	  }catch(Exception ex){
	    	 System.out.println("board Modify error"+ex);
			 
	  }finally{
			  if(rs!=null)try{rs.close();}catch(SQLException ex){}
			  if(pstmt!=null)try{pstmt.close();}catch(SQLException ex){}
	 }
		 
		 return false;  
  }
 
  //글삭제
  public boolean boardDelete(int num){
	  String board_delete_sql="DELETE FROM HYEJIN.BOARD WHERE B_NUM=?";
	  int result=0;
	  
	  try{
		  pstmt=con.prepareStatement(board_delete_sql);
		  pstmt.setInt(1, num);
		  result=pstmt.executeUpdate();
		  if(result==0){
			  return false;
		  }
		  return true;
		  
	  }catch(Exception ex){
	    	 System.out.println("board delete error"+ex);
			 
	  }finally{
			  if(rs!=null)try{rs.close();}catch(SQLException ex){}
			  if(pstmt!=null)try{pstmt.close();}catch(SQLException ex){}
	 }
		 
		 return false;  
  }
  
  //조회수업뎃
  public void setReadCountUpdate(int num) throws Exception{
	  String sql="UPDATE HYEJIN.BOARD SET B_READCOUNT";
	  sql+="B_READCOUNT+1 WHERE B_NUM="+num;
	  
	  try{
		  pstmt=con.prepareStatement(sql);
		  pstmt.executeQuery();
		  
		  
	  }catch(Exception ex){
	    	 System.out.println("set read countupdate error"+ex);
			 
	  }finally{
			  if(rs!=null)try{rs.close();}catch(SQLException ex){}
			  if(pstmt!=null)try{pstmt.close();}catch(SQLException ex){}
	 }
  }

	//작성자비번확인
	  public boolean isBoardWriter(int num, String pass){
		  String board_sql="SELECT * FROM WHERE B_NUM=?";
		  try{
			  pstmt=con.prepareStatement(board_sql);
			  pstmt.setInt(1, num);
			  rs=pstmt.executeQuery();
			  rs.next();
			  
			  if(pass.equals(rs.getString("B_PASS"))){
				  return true;
			  }
			  
		  }catch(Exception ex){
		    	 System.out.println("is board writer error"+ex);
		  } 
		 return false;
	  }
	  
	  
  }
  

