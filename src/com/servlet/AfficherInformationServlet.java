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

import com.api.MeteoAPI;
import com.api.VilleAPI;
import com.dto.MeteoDTO;
import com.dto.VilleDTO;

/**
 * Servlet implementation class PageInformationVilleServlet
 */
@WebServlet("/afficherInformation")
public class AfficherInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficherInformationServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		VilleAPI villeAPI = new VilleAPI();
		
		int offset = request.getParameter("offset") == null ? 0 : Integer.valueOf(request.getParameter("offset"));
		List<VilleDTO> villes = villeAPI.get50Villes(offset);
		
		MeteoAPI meteoAPI = new MeteoAPI();
		
		for(VilleDTO ville : villes) {
			MeteoDTO meteoDTO = meteoAPI.getWeather(ville);
			ville.setMeteo(meteoDTO);
		}
		
		session.setAttribute("listeVille", villes);
		session.setAttribute("offset", offset);
		RequestDispatcher dispatch = request.getRequestDispatcher("afficherInformation.jsp");
		dispatch.forward(request, response);
	}


}
