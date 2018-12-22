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

import com.googlecode.objectify.ObjectifyService;
import model.Person;
import service.OfyService;

/**
 * Servlet implementation class ToolsServlet
 */
@WebServlet("/ToolsServlet")
public class ToolsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    static
	{
		
	ObjectifyService.register(Person.class);
		
	}
    public ToolsServlet() {
		super();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		HttpSession session=request.getSession();
		System.out.println("IN the details context");
		String email=(String) session.getAttribute("username");
		System.out.println(email);
		try
		{
			
			List<Person> o=OfyService.ofy().load().type(Person.class).filter("username", email).list();
			String u=null,p=null;
			long n=0;
			long d;
			String id=null;
			String name=null;
			
			System.out.println(o);
			
			session.setAttribute("Tools", o);
			for(Person stu:o) {
				System.out.println((stu.getUsername()+" "+stu.getId()));
				
				 name=stu.getName();
				 u=stu.getUsername();
				 p=stu.getPassword();
				 n=stu.getPhNo();
				 id=stu.getId();
				 d=stu.getDate();
				 System.out.println("Name:"+name);
				 System.out.println("Email:"+u);
				 System.out.println("Password:"+p);
				 System.out.println("Id:"+id);
				 System.out.println("Date in mili:"+d);
					request.getRequestDispatcher("tools.jsp").forward(request, response);
				 
			}
		
	}
		catch(Exception e)
		{
			
				System.out.println("Exception Occurred");
				String message = "OOPS something went wrong, try again !!!";
				session.setAttribute("message", message);
				
				String s = session.getId();
				response.setStatus(406);
			//	response.sendRedirect("login.jsp");
				pw.println("Exception occurred");
			}

}
}

