package fr.demos.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.demos.data.ClimatisationDAO;
import fr.demos.data.FileClimatisationDAO;
import fr.demos.data.SQLClimatisationDAO;
import fr.demos.metier.Climatisation;

/**
 * Servlet implementation class ClimatisationController
 */
@WebServlet("/ClimatisationController")
public class ClimatisationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClimatisationController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/saisieClimatisation.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Climatisation clim1=new Climatisation("Samsung",25,2,35);

		boolean erreurs=false;

		//ArrayList<String> erreurs = new ArrayList();
		//request.setAttribute("erreurs", erreurs);
		String action = request.getParameter("action");
		
		RequestDispatcher rd = request.getRequestDispatcher("/saisieClimatisation.jsp");
		request.setCharacterEncoding("UTF-8");

			if (action != null && action.equals("Enregistrer")) {
				String nomAppareil = request.getParameter("nomAppareil");
				String tauxhumiditeStr = request.getParameter("tauxhumidite");
				String PressionStr = request.getParameter("pression");
				String temperatureStr = request.getParameter("temperature");

				double temperature = 0;
				double pression = 0;
				int tauxhumidite = 0;
			

				// Conversion

				try {
					temperature = Double.parseDouble(temperatureStr);
					
				} catch (NumberFormatException ex) {
					erreurs=true;
					request.setAttribute("temperatureErreur", "nombre incorrect");
				}
				
				
				try {
				
				pression = Double.parseDouble(PressionStr);	
				} catch (NumberFormatException ex) {
					erreurs=true;
					request.setAttribute("pressionErreur", "nombre incorrect");
				}
				
				try {
				
					tauxhumidite = Integer.parseInt(tauxhumiditeStr);
				} catch (NumberFormatException ex) {
					erreurs=true;
					request.setAttribute("tauxhumiditeErreur","nombre incorrect");
				}
				
				
				if(pression<0){
				
				erreurs=true;
				request.setAttribute("pressionFaux","la pression doit etre superieur à zero");
			     }
				
				if(tauxhumidite<0 && tauxhumidite>100){
					erreurs=true;
					request.setAttribute("tauxhumiditeFaux","le taux d'humidité doit etre compris entre 0 et 100!!");
				     }
					
			
				if(nomAppareil==null||nomAppareil.equals("")){
					erreurs=true;
					request.setAttribute("nomAppareilFaux"," Vous devez rentrer le nom de l'appareil");
					
				}
				
				
				request.setAttribute("nomAppareil",nomAppareil);
				request.setAttribute("tauxhumidite",tauxhumiditeStr);
				request.setAttribute("pression",PressionStr);
				request.setAttribute("temperature",temperatureStr);
				
				
				if(!erreurs){
					
					Climatisation clim= new Climatisation(nomAppareil,temperature,pression,tauxhumidite);
					
					
					try{
						ClimatisationDAO dao= new SQLClimatisationDAO();
						dao.sauve(clim);
						rd=request.getRequestDispatcher("/succesClimatisation.jsp");
						
					}catch(Exception e){
						e.printStackTrace();
						request.setAttribute("sauvegardeErreur", e.getMessage());	
					}
					
					
					rd = request.getRequestDispatcher("/succesClimatisation.jsp");
					 
				}
			}
					
			
					rd.forward(request, response);
				}
			}
		
	

