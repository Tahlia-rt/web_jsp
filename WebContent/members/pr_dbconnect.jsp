<%@ page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!
    	Connection conn;
    	PreparedStatement pstmt;
    	String jdbcDriver, dbUser, dbPass;
    	String id, password;
    	String query1="insert into table values (?, ?)";
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
    	request.setCharacterEncoding("UTF-8");
    	id=request.getParameter("id");
		password=request.getParameter("pw");    
    %>

<%
    try{ 
		Class.forName("db adrs");// =oracle.jdbc.driver.OracleDriver
    	
    	//2)/urlid/pw
    	jdbcDriver="jdbc:oracle:thin:@localhost:1521:xe";
    	dbUser="";
    	dbPass="";
    	conn=DriverManager.getConnection(jdbcDriver,dbUser,dbPass);
    	
    	//2.set here to db table..
    	pstmt=conn.prepareStatement(query1);
    	pstmt.setString(1, id);
    	pstmt.setString(2, password);
    	pstmt.executeUpdate();
   		
    	
    	out.println("success");
    	conn.commit();
    	
    }catch(Exception e){
    	e.printStackTrace();
    	out.println(e.getMessage());
    	
    }finally{
    	  if (pstmt != null) 
    		  try { 
    			  pstmt.close(); 
    			  } catch(SQLException ex){			  
    			  }finally{}
    	  if (conn != null) 
    		  try { 
    			  conn.close(); 
    			  } catch(SQLException ex) {
    				  ex.printStackTrace();
    			  }finally{}
    	
    }
    %>
</body>
</html>