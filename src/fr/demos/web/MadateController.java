package fr.demos.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.demos.metier.Climatisation;


/**
 * Servlet implementation class Madate
 */
@WebServlet("/MadateController")
public class MadateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MadateController() {
    
    }

    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
//d represente le modele

	Date d = new Date();
	Date t = new Date();
	
	
	
	// transfert du modele
	
	//String n,double t,double pression,int tauxHumidite
	Climatisation clim1=new Climatisation("Samsung",25,2,35);
	request.setAttribute("clim1",clim1);
	
	
	
	SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/y");
	String s= sdf.format(d);
	request.setAttribute("dateDuJours",s);
	
	SimpleDateFormat sdft=new SimpleDateFormat("HH:mm:ss");
	String z= sdft.format(t);
	request.setAttribute("monheure",z);
	

	
  	
	
	//appel de la vue
   RequestDispatcher rd = request.getRequestDispatcher("/madateView.jsp");
    rd.forward(request,response);
    
	
	}
	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
