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
import service.OfyService;

/**
 * Servlet implementation class ActivityServlet
 */
@WebServlet("/ActivityServlet")
public class ActivityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	static
	{
		
	ObjectifyService.register(Activity.class);
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			HttpSession session1 = request.getSession();
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			System.out.println("***************************");
			System.out.println("In the Acivity context");
			
			HttpSession session=request.getSession();
			String email=(String) session.getAttribute("username");
			
			Date d=(Date) session.getAttribute("date");
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

				response.sendRedirect("activity.jsp");
				
				
				
				
				
			}
			catch(Exception e)
			{
				System.out.println("Exception Occurred");
				String message = "OOPS something went wrong, try again !!!";
				session1.setAttribute("message", message);

				String s = session1.getId();

				response.sendRedirect("welcome.jsp");		
		}
			
			

	}
	}
