<%@ page import="java.sql.*" import="SQLite.*" import="javax.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%!
	ResultSet rs;
	Connection conn;
	PreparedStatement pstmt; //execute queries...
	String jdbcDriver, dbUser, dbPass;
	String ID, PW;
	String re;
	String query3="DELETE FROM TEST WHERE ID=?";
		//i만 삭제해도 row 모두...
%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>



<%
	request.setCharacterEncoding("UTF-8");
	ID=request.getParameter("ID");
%>

<%
	try{
		Class.forName("com.mysql.jdbc.Driver");
    	jdbcDriver="jdbc:mysql://lunchchart.com:3360/HYEJIN";
		dbUser="hyejin";
		dbPass="oracle";
		conn=DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
	
		pstmt=conn.prepareStatement(query3); //ex query
		pstmt.setString(1,ID);
		rs=pstmt.executeQuery(query3);
		
		if(rs.next()){	
			response.sendRedirect("pr_deleted.jsp");
		}else{
			out.print("failed!");
			
		}
	
	}catch(Exception e){
		out.println(e.getMessage());
		
	}finally{ // disconnecting!!
		try{
			if(pstmt != null) pstmt.close();
			if(conn != null) pstmt.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

%>

</body>
</html>