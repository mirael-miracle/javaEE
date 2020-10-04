import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
/**
 * Servlet implementation class SetCookieServlet
 */
@WebServlet("/setcookie")
public class SetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
         
        PrintWriter out = response.getWriter();
        try {
            response.addCookie(new Cookie("user", "Maxim"));
            out.println("Cookie is set");
        }
        finally {
            out.close();
        }
    }
}
