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
 * Servlet implementation class PatientShowServlet
 */
@WebServlet("/pacient")
public class PatientShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		        throws ServletException, IOException {
		        ArrayList<Pacient> pacients = PacientBD.select();
		        request.setAttribute("pacients", pacients);

		          
		        getServletContext().getRequestDispatcher("/showpacient.jsp").forward(request, response);
		    } 
  

}
