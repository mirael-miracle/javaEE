

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mysql.hospital.Doctor;
import mysql.hospital.DoctorBD;

/**
 * Servlet implementation class EditDoctorServlet
 */
@WebServlet("/edit_doctor")
public class EditDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		        throws ServletException, IOException {
		 
		        try {
		            int id = Integer.parseInt(request.getParameter("id"));
		            Doctor doctor = DoctorBD.selectOne(id);
		            if(doctor!=null) {
		                request.setAttribute("doctor", doctor);
		                getServletContext().getRequestDispatcher("/edit_doctor.jsp").forward(request, response);
		            }
		            else {
		                getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
		            }
		        }
		        catch(Exception ex) {
		            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
		        }
		    }
		     
		    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		        throws ServletException, IOException {
		 
		        try {
		            int id = Integer.parseInt(request.getParameter("id"));
		            String name = request.getParameter("name");
		            String special = request.getParameter("special");
		            Doctor doctor = new Doctor(id, name, special);
		            DoctorBD.update(doctor);
		            response.sendRedirect(request.getContextPath() + "/doctor");
		        }
		        catch(Exception ex) {
		             
		            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);   
		        }
		    }
}
