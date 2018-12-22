<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.io.*"%>
<%@ page import="model.Todo"%>
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
<title>My Home Page</title>
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
		// Header

		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");// HTTP 1.1

		response.setHeader("Pragma", "no-cache");// HTTP 1.0

		response.setHeader("Expires", "0");// Proxies

		 if (session.getAttribute("username") == null)// It is set based on the browser so everytime you login through new browser it will create a new session.
		{
			response.sendRedirect("login.jsp");
		} 
	%>
	<div class="jumbotron text-center">
	<div style="color : red">
	<p> ${message}</p>

<c:remove var="message" scope="session" /> 
	</div>
		<h3>Welcome to the Home Page</h3>
		<!--  <p>Resize this responsive page to see the effect!</p>  -->
		<div align="right">

			Welcome, <b> ${username} </b>
			<!-- JS TL -->
			<form action="Logout">
				<input type="submit" value="Logout">

			</form>
		</div>
		<a href="welcome1.jsp">Home Page</a>
			<br>
			<a href="tools.jsp"> Tools Page</a>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-sm-4">

				<!--  <div align="left"> -->
				<h3>Add Todo List</h3>
				<form action="TodoServlet" method="post">

					<input type="text" name="todo" id="todo" required
						placeholder="Type here">
						<input type="submit" value="ADD todo">
					<!-- <button>Add</button> -->
				</form>
				
			
			</div>
			
			<div class="col-sm-4">

				<!--  <div align="left"> -->
				<h3>Your Todo List</h3>
				
				
				<form action="TodoFetchServlet" method="post">
     <input type="submit" value="Get TodoList">
     </form>
     
     
				
				
				
			</div>

			<%-- <div class="col-sm-4">
				<h3>Your Todo List</h3>

				<%
					List<Todo> t1 = (List<Todo>) session.getAttribute("Result");
				%>


				<table border=2>
					<%
					
						for (Todo T1 : t1)
						{
					%>
					<tr>
					
					<td height=20px width=3000px>
					<div align="center"><font color='black'><%=T1.getText()%></font></div>
					</td>
					
					<td height=20px width=2000px>
					<div align="center"><font color='black'><%=T1.getDate()%></font></div>
					</td>
						
					<td height=20px width=100px>
					<div align="center"><font color='black'><%=T1.getDone()%></font></div>
					</td>
					
					</tr>


					<%
						}
					%>

				</table>
				

			</div> --%>
		<!-- <div class="col-sm-4">

				 <div align="left">
				<h3>Activity List</h3>
				<form action="ActivityServlet" method="post">
     <input type="submit" value="Get Activitylist">
     </form>
				
				
				
			</div> -->
			<div class="col-sm-4">
				<h3>Login Activity</h3>
				<table align="right">

					<!-- <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>
      <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris...</p> -->


					  <a href="activity.jsp">
						<button>Activity</button>
					</a>

			<!-- 		 <form action="ActivityServlet" method="post">
     <input type="submit" value="Activity">
     </form>   -->
      
				</table>

			</div>
				

		</div>
	</div>

</body>
</html>
