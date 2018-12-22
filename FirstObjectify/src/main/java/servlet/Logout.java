package servlet;
import java.io.IOException;
import java.util.Date;
import java.util.List;

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
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	static
	{
		
	ObjectifyService.register(Activity.class);
	}
	
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		HttpSession session=request.getSession();
		if(session!=null)
		{
			System.out.println("id="+session.getId());
			
			Date d=(Date) session.getAttribute("date");
			String id=(String) session.getAttribute("id");
			String email=(String) session.getAttribute("username");
			
			
			//Date d1= new Date();
			System.out.println("session id:"+id);
			long date = d.getTime();
			
			Activity ac= new Activity();
			try
			{
				List<Activity> o=OfyService.ofy().load().type(Activity.class).filter("date1", date).list();
				
				Date d1= new Date();
				long date1 = d1.getTime();
				System.out.println("Logged in date:"+d);
				System.out.println("Date in milliseconds:" + date);
				System.out.println("Logining in time:" + date);
				System.out.println("Logging out time :"+date1);
				long date2=date1-date;
				
				long date3=(date2/1000)/60;
				System.out.println("Total time spend in minutes:"+date3);
				
				//Long date2=date1-date;
				for(Activity a:o)
				{
					a.getDate2();
					a.getDate3();
				}
				
				ac.setEmail(email);
				ac.setDate(d);
				ac.setId(id);
				ac.setDate1(date);
				ac.setDate2(date1);
			    ac.setDate3((date3));
			   
			    
				OfyService.ofy().save().entity(ac).now();
				
				
				System.out.println("activity added sucessfully, stored in the database");
			
			}
			catch(Exception e)
			{
				System.out.println("Exception Occurred");
				e.printStackTrace();	
			}
			session=request.getSession(false);
			session.invalidate();
			session=null;
			
			System.out.println("logging out session");
			String message = "You are logged out !!!";
			request.getSession().setAttribute("message", message);
			response.sendRedirect("login.jsp");	
		}
		else
		{
			response.sendRedirect("login.jsp");	
		}
	}
}
