<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.io.*"%>
<%@ page import="model.Person"%>
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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tools Page</title>

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
		<h3>Welcome to the Tools Page</h3>
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
		<!-- <a href="tools.jsp">Tools Page</a> -->

	</div>




	<div class="container">
		<div class="row">
			<div class="col-sm-4">
				<p>Your details activity</p>

				Email id<b> ${username} </b>


				<!-- 	
				<div class="col-sm-4">
										<form action="IpAddressServlet" method="post">
						<input type="submit" value="Get ip address">
					</form>


				</div> -->

			</div>
		</div>
		<br>

		<div class="col-sm-4">

			<!--  <div align="left"> -->

			<form action="ToolsServlet" method="post">
				<input type="submit" value="Get Details">
			</form>

			<%
				List<Person> book = (List<Person>) session.getAttribute("Tools");
				/* Collections.sort(book); */
				//String message = (String) request.getAttribute("message");
				//	if(message!=null)
				{
			%>
			<%-- <h1><font color='yellow'><%=message%></font></h1> --%>
			<br>

			<h3>Your Details</h3>
			<%
				}
			%>


			<%
				if (book != null) {
			%>

			<table border=2>
				<%
					for (Person Book : book) {
				%>
			


 
					<td height=20px width=100px><div align="center">
							<p>
								<b>Email:
							</p>
							</b> <font color='black'><%=Book.getUsername()%></font>

						</div></td>

					<td height=20px width=100px><div align="center">

							<p>
								<b> Name: </b>
							</p>

							<font color='black'><%=Book.getName()%></font>
						</div></td>

					<td height=20px width=1000px><div align="center">
							<p>
								<b>Creation Date:</b>
							</p>

							<font color='black'><%=Book.getDate()%></font>
						</div></td>
					<td height=20px width=100px><div align="center">

							<p>
								<b>Mobile:</b>
							</p>

							<font color='black'><%=Book.getPhNo()%></font>
							<!-- 	(Book.getDate3()/1000)%60 -->
						</div></td>

					<td height=20px width=800px><div align="center">
							<p>
								<b>IP:</b>
							</p>
							<font color='black'><%=Book.getIp()%></font>

						</div></td>


					<td height=20px width=800px><div align="center">
							<p>
								<b>Country:</b>
							</p>
							<font color='black'><%=Book.getCountry()%></font>

						</div></td>



					<%-- <td height=20px width=2000px><div align="center"><p><b>Date of UserCreation:</b></p>
						<font color='black'><%=Book.getDate()%></font>
						
					</div>
				
				</td> --%>

				</tr>


				<%
					}
				%>


				<%
					}
				%>


			</table>

		</div>
</body>
</html>