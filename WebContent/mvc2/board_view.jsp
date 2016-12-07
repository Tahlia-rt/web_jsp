<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="net.board.db.*" %>

<%
   ArrayList boardList=(ArrayList)request.getAttribute("boardlist");
  int listcount=((Integer)request.getAttribute("listcount")).intValue();
  int nowpage=((Integer)request.getAttribute("page")).intValue();
  int maxpage=((Integer)request.getAttribute("maxpage")).intValue();
  int startpage=((Integer)request.getAttribute("startpage")).intValue();
  int endpage=((Integer)request.getAttribute("endpage")).intValue();

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