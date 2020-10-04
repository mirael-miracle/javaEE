import java.io.IOException;
import java.util.ArrayList;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mysql.hospital.Priyom;
import mysql.hospital.PriyomBD;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeletePriyomServlet
 */
@WebServlet("/deletepriyom")
public class DeletePriyomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		        throws ServletException, IOException {
		         
		        try {
		            int id = Integer.parseInt(request.getParameter("id"));          
		            PriyomBD.delete(id);
		            response.sendRedirect(request.getContextPath() + "/priyom");
		        }
		        catch(Exception ex) {
		            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
		        }
		    }

}
