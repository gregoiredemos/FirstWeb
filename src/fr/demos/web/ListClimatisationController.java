package fr.demos.web;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.demos.data.ClimatisationDAO;
import fr.demos.data.FileClimatisationDAO;
import fr.demos.metier.Climatisation;

/**
 * Servlet implementation class ListClimatisationController
 */
@WebServlet("/ListClimatisationController")
public class ListClimatisationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListClimatisationController() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		RequestDispatcher rd = request.getRequestDispatcher("/listClimatisation.jsp");

		ClimatisationDAO dao= new FileClimatisationDAO();
		
		List<Climatisation> listeClims=null;
		
		
		try{
			listeClims=dao.rechercheTout();
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("rechercheDataErreur", e.getMessage());
		}
		
		
		
		 request.setAttribute("climatisations", listeClims);
		 rd.forward(request, response);
		 
		 
		
		// boolean create = true;
		//HttpSession Idsession=request.getSession(create);
		
		
		
		
		
		
	//	ArrayList<Climatisation> listeClims = null;
		
		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
