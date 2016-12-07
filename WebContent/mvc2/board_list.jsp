<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="net.board.db.*" %>

<%
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판</title>
</head>
<body>

<table>


	<tr>
		<td colspan ="4">mvc게시판</td>
		<td>		</td>
	</tr>
	<tr>
		<td>
			<div>no.</div>
		</td>
		<td>
			<div>Subject</div>
		</td>
		<td>
			<div>Writer</div>
		</td>
		<td>
			<div>Date</div>
		</td>
		<td>
			<div>Reads</div>
		</td>
	</tr>

<%

//글 목록만큼 for을 돌려서 boardlist에 있는 글을 하나씩 boardbean타입으로 불러온다.


ArrayList<BoardDAO> outList = request.getAttribute("boardlist");

for(BoardDAO boardto:outList) {	

BoardBean boarddata=new BoardBean();

%>

<tr>
	<td><%= boarddata.getB_NUM() %></td>
	<td><div>
	
	<a href="./Detail.do?num<%=boarddata.getB_NUM() %>"><%=boarddata.getB_SUBJECT() %></a>
	
	
	</div></td>
	
	<td><div><%=boarddata.getB_NAME() %></div></td>
	
	<td><div><%=boarddata.getB_DATE() %></div></td>
	
	<td><div><%=boarddata.getB_READCOUNT() %></div></td>
</tr>
<%  } %>

<tr>
	<td><a href="./BoardWrite.do"> [글쓰기] </a></td>
</tr>


</table>






<br><br><br><br><br><br>
<h2>board_list페이</h2>
</body>
</html>