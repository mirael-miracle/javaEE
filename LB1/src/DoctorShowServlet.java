import java.io.IOException;


import java.util.ArrayList;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import mysql.hospital.Doctor;
import mysql.hospital.DoctorBD;


/**
 * Servlet implementation class DoctorShowServlet
 */
@WebServlet("/doctor")
public class DoctorShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		        throws ServletException, IOException {
		        ArrayList<Doctor> doctors = DoctorBD.select();
		        request.setAttribute("doctors", doctors);
		          
		        getServletContext().getRequestDispatcher("/showdoctor.jsp").forward(request, response);
		    } 
 

}
