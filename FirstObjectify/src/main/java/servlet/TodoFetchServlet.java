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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.googlecode.objectify.ObjectifyService;

import model.Activity;
import model.Todo;
import service.OfyService;


/**
 * Servlet implementation class TodoFetchServlet
 */
@WebServlet("/TodoFetchServlet")
public class TodoFetchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodoFetchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    static
	{
		
	ObjectifyService.register(Todo.class);
		
	}
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession();
		String text=request.getParameter("todo");
		System.out.println("***************************");
		
		System.out.println("In the TODO Fetch context");
		
		System.out.println(text);
		
		String email=(String) session.getAttribute("username");
		
		Date d=(Date) session.getAttribute("date");
	
		Todo t1= new Todo();
		System.out.println(email);
		
		try
		{
			

			List<Todo> o=OfyService.ofy().load().type(Todo.class).filter("email", email).list();
		/*	List<Activity> o1=OfyService.ofy().load().type(Activity.class).list();*/
		
			System.out.println(new ObjectMapper().writeValueAsString(o));
			System.out.println("Size of the result:"+o.size());

			
			if (o != null&& !o.isEmpty()&&o.size()>0)	
			{
				System.out.println(o);
				System.out.println(o.size());
			session.setAttribute("Result", o);
			
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
			}
			else
			{
				System.out.println(o);
				System.out.println(o.toString());
			//	String message = "THere is nothing in the TODO list , Please add your TODO first  !!!";
				//session.setAttribute("message", message);

				response.sendRedirect("welcome1.jsp");
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception Occurred");
			String message = "OOPS something went wrong, try again !!!";
			session.setAttribute("message", message);
			String s = session.getId();
			response.sendRedirect("welcome.jsp");
			
			
	}


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
