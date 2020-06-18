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
       
	public static final String PARAMETRE_CODE_COMMUNE = "codeCommune";
	public static final String PARAMETRE_NOM_COMMUNE = "nomCommune";
	public static final String PARAMETRE_CODE_POSTAL = "codePostal";
	public static final String PARAMETRE_LIBELLE_ACHEMINEMENT = "libelleAcheminement";
	public static final String PARAMETRE_LIGNE_5 = "ligne5";
	public static final String PARAMETRE_LATITUDE = "latitude";
	public static final String PARAMETRE_LONGITUDE = "longitude";
	
	public static final String ATTRIBUT_VILLE = "ville";
	public static final String SERVLET_AFFICHER_INFORMATION = "afficherInformation";
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

		String codeCommune = request.getParameter(PARAMETRE_CODE_COMMUNE);

		VilleAPI villeAPI = new VilleAPI();
		VilleDTO ville = villeAPI.trouverVille(codeCommune);
		
		session.setAttribute(ATTRIBUT_VILLE, ville);
		RequestDispatcher dispatch = request.getRequestDispatcher("modifierInformation.jsp");
		dispatch.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codeCommune = request.getParameter(PARAMETRE_CODE_COMMUNE);
		String nomCommune = request.getParameter(PARAMETRE_NOM_COMMUNE);
		String codePostal = request.getParameter(PARAMETRE_CODE_POSTAL);
		String libelleAcheminement = request.getParameter(PARAMETRE_LIBELLE_ACHEMINEMENT);
		String ligne5 = request.getParameter(PARAMETRE_LIGNE_5);
		String latitude = request.getParameter(PARAMETRE_LATITUDE);
		String longitude = request.getParameter(PARAMETRE_LONGITUDE);


		VilleAPI villeAPI = new VilleAPI();
		VilleDTO ville = createVille(codeCommune, nomCommune, codePostal, libelleAcheminement, ligne5, latitude, longitude);
		
		villeAPI.modifierVille(ville);
		response.sendRedirect(SERVLET_AFFICHER_INFORMATION);
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
