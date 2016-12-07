<%@ page import="java.sql.*"%>
<%-- JDBC API 임포트 작업 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!--  controller  here! -->	
	
<%!
    	Connection conn; // (작성 후 임포트처리, 연결객 has reservated pattern)
    	Statement stmt; // db sql(but "preparedStatement" is more batter to aces with many values below;)
    	PreparedStatement pstmt; // ->.prepareStatement
    	String jdbcDriver, dbUser, dbPass; //to login db
    	String query1="insert into form_ex values (?, ?)";
    	String id, password; //which from form_ex.jsp

    %>


<% 
    //1. get from form_ex.jsp with "request"
    request.setCharacterEncoding("UTF-8");
    id = request.getParameter("id");
    password= request.getParameter("pw");	
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	try{
   	//access db drivers(ojdbc6.jar) need to be moved on tomcat\lib.
	// 2-1. roading DB (should be drivers on lib from oracle..)
		Class.forName("org.sqlite.JDBC"); //db연결 ;drive에 드라이버주소 바로써도 돼.
		// suggested by each jdbc below; sqlite : http://www.tutorialspoint.com/sqlite/sqlite_java.htm
	
	// 2-2. login DB
		jdbcDriver="jdbc:oracle:thin:@localhost:1521:xe"; //
		dbUser ="hyejin0807";
		dbPass ="oracle";
		conn=DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
	    conn.setAutoCommit(false);
		out.println("MEMBER 테이블에 새로운 레코드를 삽입했습니다");
		//db에 data처리 sql.. statchment / ResultSet라는 query... 

	
	// 3-1. setting here to db table and executing
		pstmt=conn.prepareStatement(query1);
		pstmt.setString(1, id);
		pstmt.setString(2, password);
		pstmt.executeUpdate();
	
	//4. closing, disconnecting
		conn.commit();
		
		
	}catch(Exception e){	
		//error 처리
		e.printStackTrace();
		out.println(e.getMessage()); 
		out.println("cheer up!");
			}

	finally {
	//5. closing..
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