package servlet;

import java.io.IOException;
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


import model.Todo;
import service.OfyService;




/**
 * Servlet implementation class Todo
 */
@WebServlet("/TodoServlet")
public class TodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	static
	{
		
	ObjectifyService.register(Todo.class);
		
	}
	
	
	public TodoServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session1 = request.getSession();
		String text=request.getParameter("todo");
		System.out.println("***************************");
		
		System.out.println("In the TODO context");
		
		System.out.println(text);
		HttpSession session=request.getSession();
		String email=(String) session.getAttribute("username");
		System.out.println(email);
		Date d= new Date();
		String todoid = UUID.randomUUID().toString();
		System.out.println("Unique Todo id:" + todoid);
		
		
		long date = d.getTime();
		System.out.println("Date in milliseconds:" + date);

		boolean isdone = false;
		System.out.println("User isactive:" + isdone);
		
		Todo todo= new Todo(todoid, email, text, isdone, d);
		
		
		System.out.println(todoid);
		System.out.println(email);
		System.out.println(text);
		System.out.println(isdone);
		System.out.println(d);
		try
		{
			
			OfyService.ofy().save().entity(todo).now();
			System.out.println("Todo added sucessfully, stored in the database");
			//String message = "Todo added sucessfully, stored in the database";
			//session1.setAttribute("message", message);

			String s = session1.getId();
			System.out.println("Session id"+ s);
			/*List<Todo> o=OfyService.ofy().load().type(Todo.class).filter("email", email).list();
			List<Activity> o1=OfyService.ofy().load().type(Activity.class).list();
		
		//	System.out.println(o);
			
			session.setAttribute("Result", o);*/
		
			
			
			//response.sendRedirect("welcome.jsp");
			request.getRequestDispatcher("welcome1.jsp").forward(request, response);
		}
		catch(Exception e)
		{
			System.out.println("Exception Occurred");
			String message = "OOPS something went wrong, try again !!!";
			session1.setAttribute("message", message);

			String s = session1.getId();

			response.sendRedirect("welcome1.jsp");
			
			
	}

}
}




























/*List<Todo> o=OfyService.ofy().load().type(Todo.class).filter("email", email).list();
List<Activity> o1=OfyService.ofy().load().type(Activity.class).list();

System.out.println(new ObjectMapper().writeValueAsString(o));
System.out.println("Size of the result:"+o.size());


if (o != null&& !o.isEmpty()&&o.size()>0)	
{
	System.out.println(o);
	System.out.println(o.size());
session.setAttribute("Result", o);



//response.sendRedirect("welcome.jsp");
request.getRequestDispatcher("welcome.jsp").forward(request, response);
}
else
{
	System.out.println(o);
	System.out.println(o.toString());
	String message = "THere is nothing in the TODO list !!!";
	session1.setAttribute("message", message);

	response.sendRedirect("welcome1.jsp");
	
}
*/
