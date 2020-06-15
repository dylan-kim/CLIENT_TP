package com.servlet;

import java.io.IOException;
import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.api.VilleAPI;
import com.dao.VilleDAO;
import com.dto.VilleDTO;

/**
 * Servlet implementation class pageVilleServlet
 */
@WebServlet("/calculDistance")
public class CalculDistanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public CalculDistanceServlet() {
	}

	// Retourne toutes les villes
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		VilleAPI villeAPI = new VilleAPI();
		List<VilleDTO> villes = villeAPI.getVilles();

		session.setAttribute("listeVille", villes);
		RequestDispatcher dispatch = request.getRequestDispatcher("calculDistanceVille.jsp");
		dispatch.forward(request, response);

	}

	// Retourne la distance entre 2 villes
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		String codeCommuneVilleA = request.getParameter("codeCommuneVilleA");
		String codeCommuneVilleB = request.getParameter("codeCommuneVilleB");

		VilleAPI villeAPI = new VilleAPI();
		VilleDAO villeDAO = new VilleDAO();

		VilleDTO villeA = villeAPI.trouverVille(codeCommuneVilleA);
		VilleDTO villeB = villeAPI.trouverVille(codeCommuneVilleB);

		Double distanceVilles = villeDAO.calculeDistance(villeA, villeB);
		
		session.setAttribute("distanceCalculee", true);
		session.setAttribute("villeA", villeA);
		session.setAttribute("villeB", villeB);
		session.setAttribute("distanceVilles", distanceVilles);
		RequestDispatcher dispatch = request.getRequestDispatcher("calculDistanceVille.jsp");
		dispatch.forward(request, response);
	}

}
