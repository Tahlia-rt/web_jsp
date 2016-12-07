<%@ page import="java.sql.*" import="SQLite.*" import="javax.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%!

	Connection conn; //DriverManaver.getConnection()
	String jdbcDriver, dbID, dbPW;
	PreparedStatement pstmt; //conn=prepareStatement(query)
	ResultSet rs; //return each db type. executeQuery()와 짝!
	String ID, PW;
	String re;
	String query3="select * from TEST where ID =? and PW=?";
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
	ID=request.getParameter("ID");		//받는
	PW=request.getParameter("PW");
%>

	<%
	try{
		Class.forName("com.mysql.jdbc.Driver");		//드라이버 접근

		jdbcDriver="jdbc:mysql://lunchchart.com:3306/HYEJIN";		
		dbID="hyejin";
		dbPW="oracle";
		
		conn=DriverManager.getConnection(jdbcDriver, dbID, dbPW); //로긴
	
		pstmt=conn.prepareStatement(query3);//쿼리담아실행
		
		pstmt.setString(1, ID); 	//set value ID as 1(ID)'s
		pstmt.setString(2, PW);
		rs=pstmt.executeQuery(); 	// 명령의 resualt와 쿼리실행...
	
		
		if(rs.next()){		
			session.setAttribute(ID, ID);	
			session.setAttribute(PW, PW);
				out.println("welcome"+ID);
			response.sendRedirect("welcome.jsp");
				
			
		}else{
			out.print("invalid information");
		}
 		
	}catch(Exception e){
		out.println(e.getMessage());
		out.println("again!");
		
		
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