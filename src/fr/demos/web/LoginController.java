package fr.demos.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
		String action = request.getParameter("action");
		String nomErreur = request.getParameter("nomErreur");
		HttpSession session = request.getSession();

		boolean erreurs = false;

		if (action != null && action.equals("Connecter")) {
			// HttpSession=request.getSession();
			String nom = request.getParameter("nom");
			nom=nom.trim();

			if (nom == null || nom.equals("")) {
				erreurs = true;
				request.setAttribute("nomErreur", " Vous devez rentrer une chaine de caractère");
			}
			else {
				session.setAttribute("nom", nom);
				rd = request.getRequestDispatcher("/ListClimatisationController");
			}
		}

		rd.forward(request, response);
	}
}
