package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import model.Activity;

import com.googlecode.objectify.ObjectifyService;
import service.OfyService;

/**
 * Servlet implementation class ActivityFetchServlet
 */
@WebServlet("/ActivityFetchServlet")
public class ActivityFetchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 	static
	{
		
	ObjectifyService.register(Activity.class);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		System.out.println("***************************");
		System.out.println("In the Acivity context");
		
		HttpSession session=request.getSession();
		String email=(String) session.getAttribute("username");
		
		Date d=(Date) session.getAttribute("date");
	
		Activity a1= new Activity();
	
		
		System.out.println(email);

		try
		{
			
			List<Activity> o=OfyService.ofy().load().type(Activity.class).filter("email", email).list();
			List<Activity> o1=OfyService.ofy().load().type(Activity.class).list();
			String u=null;
			Date p=null;
		//	System.out.println(o);
			
			session.setAttribute("Result1", o);
			for(Activity stu:o) {
				System.out.println((stu.getEmail()+" "+stu.getDate()+" "+stu.getDate1()+" "+stu.getDate2()));
				
				 u=stu.getEmail();
				 p=stu.getDate();
				/* pw.println(u);
				 pw.println(p);*/
				 
			//	 pw.println(stu.getEmail() + " \n "+stu.getDate());
				// pw.println();
			}
			
			System.out.println("===================");
			
			/*for(Activity stu:o1) {
				//System.out.println((stu.getEmail()+" "+stu.getDate()));
				
				 u=stu.getEmail();
				 p=stu.getDate();
				 pw.println(stu.getEmail() );
				 
				 pw.println(stu.getDate());
				 //pw.println(p);
			}*/
		
		
			session.setAttribute("email", email);
			//Date d= new Date();
			session.setAttribute("date", p);
			
			
			
			/*pw.print("Welcome, login sucess");*/
			System.out.println("Login sucess");
			response.setStatus(201);
			//response.sendRedirect("activity.jsp");
			request.getRequestDispatcher("activity.jsp").forward(request, response);
		
		
			
			/*System.out.println("Fail");
			pw.println("email not found");

			String message = "Login failed, Please try with correct Username and Password !!!!";
			request.getSession().setAttribute("message", message);
*/
			/*String s = request.getSession().getId();

			response.sendRedirect("welcome.jsp");*/
		
		
		}
		catch(Exception e)
		{
			
				System.out.println("Exception Occurred");
				String message = "OOPS something went wrong, try again !!!";
				session.setAttribute("message", message);
				
				String s = session.getId();
				response.setStatus(406);
				response.sendRedirect("welcome.jsp");
				pw.println("Exception occurred");
			}
		}
		
		
}
