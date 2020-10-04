import java.io.IOException;
import java.util.ArrayList;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mysql.hospital.Pacient;
import mysql.hospital.PacientBD;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeletePacientServlet
 */
@WebServlet("/deletepacient")
public class DeletePacientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		        throws ServletException, IOException {
		         
		        try {
		            int id = Integer.parseInt(request.getParameter("id"));          
		            PacientBD.delete(id);
		            response.sendRedirect(request.getContextPath() + "/pacient");
		        }
		        catch(Exception ex) {
		            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
		        }
		    }

}
