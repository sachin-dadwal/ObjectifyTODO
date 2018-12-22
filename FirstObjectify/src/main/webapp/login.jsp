<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WELCOME TO MY PROJECT</title>
</head>
<body >

	
	
<!-- bgcolor="Yellow" -->

<div align="center">
<h1><font color='red'>Welcome to The Typhoon Project</font></h1>
<br>
<h2>Login</h2>

<div style="color : red">
	<p> ${message}</p>

<c:remove var="message" scope="session" /> 
	</div>		
	
	<%session.invalidate();%>
	
<form action="Login"  method="post">

	<label for="username">	Username:</label>

<input id="username" type="email" placeholder="Email*" required name="username">  <br><br>

<label for="password">	Password:</label>

<input id="password" type="password" placeholder="Password*" required name="password"><br>

<!-- <button>Submit</button> -->
<br>
 
<input type="Submit">

</form>

<form action="Signup.jsp" method="post">


<br>

<label>New Here?</label>
				
<br>
 <button>SignUp</button>
</form>


</div>
<br>
<br>
<br>
<br>
<div align="center">
<footer><a href="mailto:sdadwal54@gmail.com?subject=Email%20Subject&body=Email%20Body%20Text"><font color='blue'>Email Me :)</font></a> </footer>
</div>
</body>
</html>