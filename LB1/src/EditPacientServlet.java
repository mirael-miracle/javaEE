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
 * Servlet implementation class EditPacientServlet
 */
@WebServlet("/edit_pacient")
public class EditPacientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		        throws ServletException, IOException {
		 
		        try {
		            int id = Integer.parseInt(request.getParameter("id"));
		            Pacient pacient = PacientBD.selectOne(id);
		            if(pacient!=null) {
		                request.setAttribute("pacient", pacient);
		                getServletContext().getRequestDispatcher("/edit_pacient.jsp").forward(request, response);
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
		            String skarga = request.getParameter("skarga");
		            Pacient pacient = new Pacient(id, name, skarga);
		            PacientBD.update(pacient);
		            response.sendRedirect(request.getContextPath() + "/pacient");
		        }
		        catch(Exception ex) {
		             
		            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);   
		        }
		    }
}
