package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.googlecode.objectify.ObjectifyService;

import model.Activity;
import model.Person;
import service.OfyService;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	
	}*/
	
	static
	{
		
	ObjectifyService.register(Person.class);
	ObjectifyService.register(Activity.class);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String uname1 = request.getParameter("username");
		String pass = request.getParameter("password");
		String uname=uname1.toLowerCase();
		System.out.println(uname);
		System.out.println(pass);
		
		
		HttpSession session=null;

		try
		{
			
			List<Person> o=OfyService.ofy().load().type(Person.class).filter("username", uname).list();
			String u=null,p=null;
			System.out.println(o);
			for(Person stu:o) {
				System.out.println((stu.getUsername()+" "+stu.getPassword()));
				
				 u=stu.getUsername();
				 p=stu.getPassword();
			}
		
		if(u.equals(uname)&&p.equals(pass))
		{
			System.out.println("Pass");
		session = request.getSession();
			session.setAttribute("username", uname);
			Date d= new Date();
			session.setAttribute("date", d);
			pw.print("Welcome, login sucess");
			System.out.println("Login sucess");
			response.setStatus(201);
		
			
			HttpSession session1 = request.getSession();
			response.setContentType("text/html");
		//	PrintWriter pw = response.getWriter();
			System.out.println("***************************");
			System.out.println("In the Acivity context");
			
			//HttpSession session=request.getSession();
			String email=(String) session.getAttribute("username");
			
			//Date d=(Date) session.getAttribute("date");
			System.out.println(email);
			
			
			
			final String activityid = UUID.randomUUID().toString();
			
			
			System.out.println("Unique Todo id:" + activityid);
			
			session.setAttribute("id", activityid);
			
						
			long date = d.getTime();
			System.out.println("Date in milliseconds:" + date);
	
			long date1=0L;
			Activity activity= new Activity(activityid,email,d,date,date1,date1);
					
					//session1.setAttribute("date", date);
			
			
			System.out.println(activityid);
			System.out.println(email);
		
			System.out.println(d);
			try
			{
				
				
				OfyService.ofy().save().entity(activity).now();
				System.out.println("activity added sucessfully, stored in the database");
			//	String message = "activity added sucessfully, stored in the database";
				//session1.setAttribute("message", message);

				String s = session1.getId();

				//response.sendRedirect("activity.jsp");
				response.sendRedirect("welcome1.jsp");
				
				
				
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Exception Occurred");
				System.out.println("Activity not saved");
				String message = "OOPS something went wrong, try again !!!";
				session1.setAttribute("message", message);

				String s = session1.getId();

				response.sendRedirect("login.jsp");		
		}
			
		}
		else
		{
			System.out.println("Fail");
			System.out.println("Fail");
			pw.println("Login failed");

			String message = "Login failed, Please try with correct Username and Password !!!!";
			request.getSession().setAttribute("message", message);

			String s = request.getSession().getId();

			response.sendRedirect("login.jsp");
		}
		
		}
		catch(Exception e)
		{
			
				System.out.println("Exception Occurred");
				String message = "OOPS something went wrong, try again !!!";
				session.setAttribute("message", message);
				
				String s = session.getId();
				response.setStatus(406);
				response.sendRedirect("login.jsp");
				pw.println("Exception occurred");
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		/*if (uname.equals("admin") && pass.equals("admin")) {
			
			HttpSession session = request.getSession();
			session.setAttribute("username", uname);
			pw.print("Welcome, login sucess");
			System.out.println("Login sucess");
			response.sendRedirect("welcome.jsp");

		} else {
			System.out.println("Fail");
			pw.println("Login failed");

			String message = "Login failed, Please try with correct Username and Password !!!!";
			request.getSession().setAttribute("message", message);

			String s = request.getSession().getId();

			response.sendRedirect("login.jsp");

		}*/

	

}
