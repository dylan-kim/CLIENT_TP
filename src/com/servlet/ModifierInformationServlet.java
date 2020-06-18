package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.api.VilleAPI;
import com.dto.VilleDTO;

/**
 * Servlet implementation class PageModifierInformation
 */
@WebServlet("/modifierInformation")
public class ModifierInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierInformationServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		String codeCommune = request.getParameter("codeCommune");

		VilleAPI villeAPI = new VilleAPI();
		VilleDTO ville = villeAPI.trouverVille(codeCommune);
		
		session.setAttribute("ville", ville);
		RequestDispatcher dispatch = request.getRequestDispatcher("modifierInformation.jsp");
		dispatch.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codeCommune = request.getParameter("codeCommune");
		String nomCommune = request.getParameter("nomCommune");
		String codePostal = request.getParameter("codePostal");
		String libelleAcheminement = request.getParameter("libelleAcheminement");
		String ligne5 = request.getParameter("ligne5");
		String latitude = request.getParameter("latitude");
		String longitude = request.getParameter("longitude");


		VilleAPI villeAPI = new VilleAPI();
		VilleDTO ville = createVille(codeCommune, nomCommune, codePostal, libelleAcheminement, ligne5, latitude, longitude);
		
		villeAPI.modifierVille(ville);
		response.sendRedirect("afficherInformation");
	}

	private VilleDTO createVille(String codeCommune, String nomCommune, String codePostal, String libelleAcheminement, String ligne5,
			String latitude, String longitude) {
		VilleDTO ville = new VilleDTO();
		ville.setCodeCommune(codeCommune);
		ville.setNomCommune(nomCommune);
		ville.setCodePostal(codePostal);
		ville.setLatitude(latitude);
		ville.setLongitude(longitude);
		ville.setLibelleAcheminement(libelleAcheminement);
		ville.setLigne5(ligne5);
		return ville;
	}

}
