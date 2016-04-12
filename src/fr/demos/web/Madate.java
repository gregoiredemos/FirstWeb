package fr.demos.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Madate
 */
@WebServlet("/Madate")
public class Madate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Madate() {
    
    }

    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

	response.setContentType("text/html;charset=UTF-8");
	PrintWriter out = response.getWriter();
	Date d = new Date();
	try {
	out.println("<html>");
	out.println("<head>");
	out.println("<title> LaDate</title>");
	out.println("</head>");
	out.println("<body>");
	out.println("<h1> nous sommes le : " + d + "</h1>");
	out.println("<h2> Mon premier test </h2>");
	out.println("</body>");
	out.println("</html>");
	
	}
	finally {
	out.close(); 
	}
	}	
	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
