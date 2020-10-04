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
 * Servlet implementation class EditPriyomServlet
 */
@WebServlet("/edit_priyom")
public class EditPriyomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		        throws ServletException, IOException {
		 
		        try {
		            int id = Integer.parseInt(request.getParameter("id"));
		            Priyom priyom = PriyomBD.selectOne(id);
		            if(priyom!=null) {
		                request.setAttribute("priyom", priyom);
		                getServletContext().getRequestDispatcher("/edit_priyom.jsp").forward(request, response);
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
		            String skarga = request.getParameter("skarga");
		            String diagnos = request.getParameter("diagnos");
		            String datapr = request.getParameter("datapr");
		            Priyom priyom = new Priyom(id,skarga, diagnos, datapr);
		            PriyomBD.update(priyom);
		            response.sendRedirect(request.getContextPath() + "/priyom");
		        }
		        catch(Exception ex) {
		             
		            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);   
		        }
		    }

}
