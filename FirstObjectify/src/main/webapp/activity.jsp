<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.io.*"%>
<%@ page import="model.Activity"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="service.OfyService"%>
<%@ page import="com.googlecode.objectify.ObjectifyService"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Collections"%>
<%@ page import="javax.servlet.ServletException"%>
<%@ page import="javax.servlet.annotation.WebServlet"%>
<%@ page import="javax.servlet.http.HttpServlet"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="javax.servlet.http.HttpServletResponse"%>
<%-- 	<%@ page import=""%> --%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>My Activity Page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>

	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");// HTTP 1.1
		response.setHeader("Pragma", "no-cache");// HTTP 1.0
		response.setHeader("Expires", "0");// Proxies

		if (session.getAttribute("username") == null)// It is set based on the browser so everytime you login through new browser it will create a new session.
		{
			response.sendRedirect("login.jsp");
		}
	%>
	<div class="jumbotron text-center">
		<h3>Welcome to the Login Activity Page</h3>
		<!--  <p>Resize this responsive page to see the effect!</p>  -->
		<div align="right">

			<!--
<div align="center">
<h3>Welcome to the Home Page</h3>
  <a href="videos.jsp">Videos</a>
</div>-->

			Welcome, <b> ${username} </b>
			<!-- JS TL -->
			<form action="Logout">
				<input type="submit" value="Logout">

			</form>
		</div>

		<a href="welcome1.jsp">Home Page</a>

	</div>

	<div class="container">

		<div class="row">

			<div class="col-sm-4">
				<h3>Login Activity</h3>
				<p>Your login activity</p>
				<!--   <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris...</p> -->

				<!--   <table align="center"      class="table table-bordered" bordercolor="black" height="300" width="300" bgcolor="Yellow">
     
   <thead>
      <tr>
        <th>Activity</th>
        
     
      </tr>
    </thead> -->
				Email id<b> ${username} </b>
				</table>
			</div>


			<div class="col-sm-4">

				<form action="ActivityFetchServlet" method="post">
					<input type="submit" value=" Get Activity">
				</form>
				<!-- <a href="activity.jsp">Activity</a> -->
			</div>


			<%
				List<Activity> book = (List<Activity>) session.getAttribute("Result1");
				/* Collections.sort(book); */
				//String message = (String) request.getAttribute("message");
				//	if(message!=null)
				{
			%>
			<%-- <h1><font color='yellow'><%=message%></font></h1> --%>


			<%
				}
			%>


			<%
				if (book != null) {
			%>

			<table border=2>
				<%
					for (Activity Book : book) {
				%>




				<%-- <td height=80px width=400px><div align="center"><font color='black'><%=Book.getEmail()%></font></div></b></h3></td> --%>


				<td height=20px width=400px><div align="center">
						<p>
							<b>Logged in Date:</b>
						</p>
						<font color='black'><%=Book.getDate()%></font>

					</div></td>


				<td height=20px width=400px><div align="center">
						<p>
							<b>Total time spent(minutes):</b>
						</p>
						<font color='black'><%=Book.getDate3()%></font>
						<!-- 	(Book.getDate3()/1000)%60 -->
					</div></td>


				<%-- <td height=100px width=400px><h2><b><div align="center"><font color='yellow'><u>Date:</u></font></div></b></h2><br><h3><b><div align="center"><font color='black'><%=Book.getDate()%></font></div></b></h3></td> --%>


				</tr>


				<%
					}
				%>


				<%
					}
				%>


			</table>

		</div>



		<%-- <table>
<tr><td>EMail id </td><td > ${email}</td></tr>
<tr><td >Date</td><td > ${date}</td></tr>
<tr><td >CD Cost:</td><td ><input type='text' name='cost' id='cost'></td></tr>
<tr><td>Release Date:</td><td ><input type='text' name='release' id='release'></td></tr>
<tr><td></td></tr>
</table>
 --%>
</body>
</html>
