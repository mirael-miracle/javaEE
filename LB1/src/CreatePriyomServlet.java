

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysql.hospital.Priyom;
import mysql.hospital.PriyomBD;

/**
 * Servlet implementation class CreatePriyomServlet
 */
@WebServlet("/CreatePriyomServlet")
public class CreatePriyomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		        throws ServletException, IOException {
		 
		        getServletContext().getRequestDispatcher("/create_priyom.jsp").forward(request, response);
		    }
		     
		    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		        throws ServletException, IOException {
		 
		        try {
		            String skarga = request.getParameter("skarga");
		            String diagnos = request.getParameter("diagnos");
		            String datapr = request.getParameter("datapr");
		            Priyom priyom = new Priyom(skarga, diagnos, datapr);
		            PriyomBD.insert(priyom);
		            response.sendRedirect(request.getContextPath()+"/priyom");
		        }
		        catch(Exception ex) {
		             
		            getServletContext().getRequestDispatcher("/create_priyom.jsp").forward(request, response); 
		        }
		    }

}
