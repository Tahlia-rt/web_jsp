<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
  String pagefile=request.getParameter("page");
  if(pagefile==null){
	  pagefile="intro.jsp";
  }else{
	  pagefile=pagefile+".jsp";
  }
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>곽혜진 프로필 </title>
<link rel="stylesheet" href="css/index.css">
<link href="https://fonts.googleapis.com/css?family=Dosis|Kalam|Neucha|Roboto+Mono|Ubuntu" rel="stylesheet" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

</head>
<body>
	<div id="index" class="wrap">

		<div class="menubar">
			<jsp:include page="menubar.jsp" />
		</div>


		<div class="center">
			<jsp:include page="<%=pagefile%>" />
		</div>


	</div>
</body>
</html>
