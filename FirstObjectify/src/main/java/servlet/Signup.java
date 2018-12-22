package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.net.InetAddress;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

//import com.googlecode.objectify.Result;


import model.Person;
import service.OfyService;

/**
 * Servlet implementation class Signup
 */
@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Signup() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		HttpSession session1 = request.getSession();

		String uname1 = request.getParameter("email");
		String uname=uname1.toLowerCase();
		System.out.println("Username: " + uname);

		String pass = request.getParameter("password");
		System.out.println("password: " + pass);
		String name = request.getParameter("name");
		System.out.println("FullName: " + name);
		String mobile = request.getParameter("mobile");
		long phno = Long.parseLong(mobile);
		System.out.println("MobileNumber: " + mobile);

		String id = UUID.randomUUID().toString();
		System.out.println("Unique Customer id:" + id);

		Date d = new Date();
		long date = d.getTime();
		System.out.println("Date in milliseconds:" + date);

		boolean isactive = false;
		System.out.println("User isactive:" + isactive);
		
		
		////////////////////////////////////IP
		String ipAddress=null;
		
		String getWay = request.getHeader("VIA");   // Gateway
		ipAddress = request.getHeader("X-FORWARDED-FOR");   // proxy
		if(ipAddress==null)
		{
		    ipAddress = request.getRemoteAddr();
		}
		System.out.println("IP Address: "+ipAddress);
		String agent=request.getHeader("user-agent");
		String loc=request.getLocale().getDisplayCountry();
		System.out.println(agent);
		System.out.println(loc);
		
		
		
		
		//pw.println(ipAddress);
		////////////////////////////////////////////////////////////////////////////
		
		Person person = new Person(id, uname, pass, name, phno, isactive, date,ipAddress,loc);

		try

		{

			List<Person> results = OfyService.ofy().load().type(Person.class).filter("username", uname).list();
			
			pw.println(new ObjectMapper().writeValueAsString(results));
			pw.print("Size of the result:"+results.size());

			if (results != null&& !results.isEmpty()&&results.size()>0) {
				pw.println("Email already registered");
				System.out.println("Email already registered");
				pw.println("Success");
				String message = "Email already registered, Please try with another email id";
				session1.setAttribute("message", message);

				String s = session1.getId();

				response.sendRedirect("Signup.jsp");
			} else {

				OfyService.ofy().save().entity(person).now();

				// Person c = ofy().load().type(Person.class).id(id).now();

				// System.out.println(c.getId());
				System.out.println("Saved");

				/*
				 * Entity person = new Entity("Person", uname);
				 * 
				 * person.setProperty("Password", pass); person.setProperty("Name", name);
				 * person.setProperty("MobileNumber", mobile);
				 * 
				 * Key key = KeyFactory.createKey("Person", uname);
				 * 
				 * 
				 * 
				 * 
				 * 
				 * DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
				 */

				pw.println("Account Created sucessfulyy");
				System.out.println("Login now");
				pw.println("Success");
				String message = "Account Created sucessfuly, You can Login now";
				session1.setAttribute("message", message);

				String s = session1.getId();

				response.sendRedirect("login.jsp");
			}

		} catch (Exception e) {
			System.out.println("Exception Occurred");
			String message = "OOPS something went wrong, try again !!!";
			session1.setAttribute("message", message);

			String s = session1.getId();

			response.sendRedirect("login.jsp");
			pw.println("Exception occurred");
		}

		// datastore.put(person);

	}
}
