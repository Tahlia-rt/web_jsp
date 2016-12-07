<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%!
	ResultSet rs;
	Connection conn;
	PreparedStatement pstmt;
	String jdbcDriver, dbUser, dbPass;
	String id, password;
	String query2="select * from form_ex where id='', pw='' ";

%>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
	<th>id</th>
	<th>pw</th>
</tr>
</table>

<%
	request.setCharacterEncoding("UTF-8");
	id=request.getParameter("id");
	password=request.getParameter("pw");
%>

<%
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
    	jdbcDriver="jdbc:oracle:thin:@localhost:1521:xe";
		dbUser="hyejin";
		dbPass="oracle";
		conn=DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
	
		//setString없지!
	
		pstmt=conn.prepareStatement(query2);
		rs=pstmt.executeQuery(query2);
		
		 while(rs.next()){
		%>
			<tr>
			<td><%= rs.getString("id") %></td>
			<td><%= rs.getString("pw") %></td>
			</tr>				
		<%
		} out.println("searched");
	
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