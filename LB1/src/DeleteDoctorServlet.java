

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mysql.hospital.Doctor;
import mysql.hospital.DoctorBD;



/**
 * Servlet implementation class DeleteDoctorServlet
 */
@WebServlet("/deletedoctor")
public class DeleteDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		        throws ServletException, IOException {
		         
		        try {
		            int id = Integer.parseInt(request.getParameter("id"));          
		            DoctorBD.delete(id);
		            response.sendRedirect(request.getContextPath() + "/doctor");
		        }
		        catch(Exception ex) {
		            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
		        }
		    }
}
