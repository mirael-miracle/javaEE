

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import javax.ejb.EJB;

import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejb3_2_components.IHelloWorld;
@WebServlet("/hello")
public class ServletHello extends HttpServlet
{
    @EJB 
    private IHelloWorld hello; 
 
    private static final long serialVersionUID = 1L;
       
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException 
    {
        try {
            String answer = hello.sayHello(request.getParameter("name"));
            request.getSession().setAttribute("answer", answer); 
            RequestDispatcher rd;
            rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response); 
        } catch (Exception e) { 
            throw new ServletException(e.getMessage()); 
        } 
    }
}
