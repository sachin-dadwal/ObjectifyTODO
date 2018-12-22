<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up Page</title>
</head>
<body>

<div align="center">

	<div style="padding: 10px 0 0; text-align: center;">

				<h1><span style="font-weight: normal;">Create an Account for</span> Free!</h1>
			</div>
			<!-- <div>
				<span>Get a free account in 30 seconds. No credit card required.</span>
			</div> -->
			
				<h2><a href="login.jsp"> <font color='black'>Login Page</font></a></h2>
			<br>
			
			<%-- <p>Message: ${message}</p> --%>
			<div style="color : red"><p> ${message}</p>
			
            <c:remove var="message" scope="session" /> 
			</div>
			
			<%session.invalidate();%>
			
			
			
			
<form action="Signup" method="post">

<label for="username">	Email :</label>
<input id="username" type="email"  placeholder="Email*"   required name="email"><br>

<label for="Name">	Name :</label>
<input id="name" type="name" placeholder="Name*" required  name="name"><br>

<label for="mobile">Mobile: </label>
<input id="mobile" type="text" placeholder="Enter 10 digit number*"  maxlength="10"  required name="mobile"><br>

<!-- onkeypress="return isNumber(event)" --> 

<label for="password">Password :</label>

<input id="password" type="password" placeholder="Password*"  required name="password">



<br>

<!-- <label>New Here?</label> -->
				
<br>
 <button><span >CREATE MY ACCOUNT!</span></button>
 
</form>
</div>
<!-- <script>


function isNumber(evt) {
    evt = (evt) ? evt : window.event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
        return false;
    }
    return true;
}


</script> -->
</body>
</html>




















<!-- <div id="password-template" style="display:none">
		<ul class="ticks">
		<li id="pass-text" class="min">Your password must contain at least 8 characters</li>
		<li id="pass-text" class="char">Password must contain letter and number</li>
		<li id="pass-text" class="cmn">Don&#039;t even think about using common passwords like &#039;password&#039;</li>
		</ul>
		</div> -->