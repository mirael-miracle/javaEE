import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class GetCookieServlet
 */
@WebServlet("/getcookie")
public class GetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	            throws ServletException, IOException {
	         
	         
	        Cookie[] cookies = request.getCookies();
	        String cookieName = "user";
	        Cookie cookie = null;
	        if(cookies !=null) {
	            for(Cookie c: cookies) {
	                if(cookieName.equals(c.getName())) {
	                    cookie = c;
	                    break;
	                }
	            }
	        }
	        PrintWriter out = response.getWriter();
	        try {
	            out.println("Name: " + cookie.getValue());
	        }
	        finally {
	            out.close();
	        }
	    }
}
