import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/setsession")
public class SetSessionServlet extends HttpServlet {
  
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	            throws ServletException, IOException {
	         
	        HttpSession session = request.getSession();
	        Person max = (Person) session.getAttribute("person");
	        session.setMaxInactiveInterval(-1);// до закрытия браузера
	        PrintWriter out = response.getWriter();
	        try {
	            if(max == null) {
	 
	                max = new Person("Maxim", 19);
	                session.setAttribute("person", max);
	                out.println("Session data are set");
	            }
	            else {
	                out.println("Name: " + max.getName() + " Age: " + max.getAge());
	                session.removeAttribute("person");
	            }
	        }
	        finally {
	            out.close();
	        }
	    }
}