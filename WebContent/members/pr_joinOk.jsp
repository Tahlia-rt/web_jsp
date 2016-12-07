<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import = "java.sql.*" %>
    



<%!
	ResultSet rs;
	Connection conn;
	PreparedStatement pstmt;
	String jdbcDriver, dbUser, dbPass;
	String ID, PW;
	String re;
	String query4="insert into TEST (ID,PW) values (?,?)"; //작은따옴표없음!

%>

<%
	request.setCharacterEncoding("UTF-8");
	ID=request.getParameter("ID");
	PW=request.getParameter("PW");
	
	
	try{
		Class.forName("com.mysql.jdbc.Driver");
		jdbcDriver = "jdbc:mysql://lunchchart.com:3306/HYEJIN";
		dbUser="hyejin";
		dbPass="oracle";
		conn=DriverManager.getConnection(jdbcDriver,dbUser,dbPass);
		
		pstmt=conn.prepareStatement(query4);
		pstmt.setString(2, ID);
		pstmt.setString(1, PW);
		pstmt.executeUpdate(); //적용된 수 반환(int)
		
		out.println("회원가입 되셨습니다!");
		response.sendRedirect("pr_joined.jsp");
		
	}catch(Exception e){
		e.printStackTrace();
		out.print(e.getMessage());
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


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">




<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>