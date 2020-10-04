import java.io.IOException;

import java.util.ArrayList;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mysql.hospital.Pacient;
import mysql.hospital.PacientBD;
/**
 * Servlet implementation class CreatePacientServlet
 */
@WebServlet("/create_pacient")
public class CreatePacientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		        throws ServletException, IOException {
		 
		        getServletContext().getRequestDispatcher("/create_pacient.jsp").forward(request, response);
		    }
		     
		    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		        throws ServletException, IOException {
		 
		        try {
		            String name = request.getParameter("name");
		            String skarga = request.getParameter("skarga");
		            Pacient pacient = new Pacient(name, skarga);
		            PacientBD.insert(pacient);
		            response.sendRedirect(request.getContextPath()+"/pacient");
		        }
		        catch(Exception ex) {
		             
		            getServletContext().getRequestDispatcher("/create_pacient.jsp").forward(request, response); 
		        }
		    }

}
