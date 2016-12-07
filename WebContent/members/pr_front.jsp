<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "java.util.*"
    session="true" buffer="16kb" autoFlush="true" isThreadSafe="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>06/24</title>



</head>
<body>

<h3> Join </h3>
	<form action="pr_joinOk.jsp" method="post">
		<label for="id">id </label><input type="text" name="ID"><br>
		<label for="pw">pw </label><input type="password" name="PW"><br>
		<input type="submit" value="Join"><br><br>
	</form>



<h3> Login </h3>
	<form action="pr_loginOk.jsp" method="post">
		<label for="id">id </label><input type="text" name="ID"><br>
		<label for="pw">pw </label><input type="password" name="PW"><br>
		<input type="submit" value="submit"><br><br>
	</form>
	

<h3> Delete </h3>
	<form action="pr_deleteOk.jsp" method="post">
	<label for="id"> id: </label> <!-- rule -->
	<input type="text" name="ID">
	<input type="submit" value="delete"><br><br>
	</form>
	
<h3> Modify</h3>
<form action="pr_modifyOk.jsp" method="post">
	<label for="ID">id : </label><input type="text" name="ID"><br>
	<label for="PW">pw : </label><input type="password" name="PW">
	<input type="submit" value="modify"><br>

</form>
<br><br>
	
	<% Date date= new Date();%>
   <%= date.toLocaleString() %> 



</body>
</html>