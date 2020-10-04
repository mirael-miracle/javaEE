

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mysql.hospital.Doctor;
import mysql.hospital.DoctorBD;


/**
 * Servlet implementation class CreateDoctorServlet
 */
@WebServlet("/create_doctor")
public class CreateDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		        throws ServletException, IOException {
		 
		        getServletContext().getRequestDispatcher("/create_doctor.jsp").forward(request, response);
		    }
		     
		    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		        throws ServletException, IOException {
		 
		        try {
		            String name = request.getParameter("name");
		            String special = request.getParameter("special");
		            Doctor doctor = new Doctor(name, special);
		            DoctorBD.insert(doctor);
		            response.sendRedirect(request.getContextPath()+"/doctor");
		        }
		        catch(Exception ex) {
		             
		            getServletContext().getRequestDispatcher("/create_doctor.jsp").forward(request, response); 
		        }
		    }


}
