<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" href="css/people.css">
<link rel="stylesheet" href="css/web.css">
<link rel="stylesheet" href="css/jquery.mCustomScrollbar.css" />
<script type="text/javascript" src="js/web.js"></script>

</head>
<body>

	<div id="web" class="wrap">
		<div class="first">
			<div>
				<div><p>아래는 웹 기능이 구현되어있으며 차후 추가예정입니다.<br> jQuery, 게시판(MVC2)</p></div>
			</div>
		</div>
		<div class="people">
			<div class="bar">▼Hover and Click characters below!▼</div>
			<div class="light">
				<div class="lighting">
					<img src="imgs/web/light.png" />
				</div>
				<div class="crts">
					<ul id="crts">
						<li></li>
						<li></li>
						<li></li>
						<li></li>
						<li></li>
						<li></li>
						<li></li>
					</ul>
				</div>
			</div>
		</div>

		<div class="board">
		<div>
		<jsp:include page="board_list.jsp"/>
		</div>		
		</div>
	</div>
</body>
</html>