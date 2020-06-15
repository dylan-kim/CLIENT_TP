package com.api;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import com.dto.VilleDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.util.RequeteGet;
import com.util.RequetePost;

public class VilleAPI {
	
	public static final String ADRESSE_SERVER = "http://localhost:8080/";
	
	public List<VilleDTO> getVilles() throws JsonMappingException, JsonProcessingException {
		String url = ADRESSE_SERVER + "villes";
		RequeteGet get = new RequeteGet();
		String jsonString = get.requeteGet(url);
		ObjectMapper mapper = new ObjectMapper();
		List<VilleDTO> villes = mapper.readValue(jsonString, new TypeReference<List<VilleDTO>>(){});
		return villes;
	}
	
	public List<VilleDTO> get50Villes(int offset) throws JsonMappingException, JsonProcessingException {
		String url = ADRESSE_SERVER + "50villes?offset=" + offset;
		RequeteGet get = new RequeteGet();
		String jsonString = get.requeteGet(url);
		ObjectMapper mapper = new ObjectMapper();
		List<VilleDTO> villes = mapper.readValue(jsonString, new TypeReference<List<VilleDTO>>(){});
		return villes;
	}
	
	public VilleDTO trouverVille(String codeCommune) throws JsonMappingException, JsonProcessingException {
		String url = ADRESSE_SERVER + "ville?codeCommune=" + codeCommune;
		RequeteGet get = new RequeteGet();		
		String jsonString = get.requeteGet(url);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		VilleDTO ville = mapper.readValue(jsonString, VilleDTO.class);
		return ville;
	}
	
	// URL Encore prevent blank space in the URI and replace it with "+" to avoid errors 
	// in the call
	public void modifierVille(VilleDTO ville) throws UnsupportedEncodingException {
		String url = ADRESSE_SERVER + "ville/modifier?Code_commune_INSEE=" + ville.getCodeCommune()
		+ "&Nom_commune=" + URLEncoder.encode(ville.getNomCommune(), "UTF-8")
		+ "&Code_postal=" + ville.getCodePostal()
		+ "&Libelle_acheminement=" + URLEncoder.encode(ville.getLibelleAcheminement(), "UTF-8")
		+ "&Ligne_5=" + ville.getLigne5()
		+ "&Latitude=" + ville.getLatitude()
		+ "&Longitude=" + ville.getLongitude();
		RequetePost post = new RequetePost();
		post.requetePost(url);
	}
	
	
	
}
