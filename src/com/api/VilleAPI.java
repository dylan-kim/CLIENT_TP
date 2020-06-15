package com.api;

import java.util.List;

import org.apache.http.NameValuePair;

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
	
	
	public VilleDTO trouverVille(String codeCommune) throws JsonMappingException, JsonProcessingException {
		String url = ADRESSE_SERVER + "ville?codeCommune=" + codeCommune;
		RequeteGet get = new RequeteGet();		
		String jsonString = get.requeteGet(url);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		VilleDTO ville = mapper.readValue(jsonString, VilleDTO.class);
		return ville;
	}
	
	
	public void modifierVille(List<NameValuePair> urlParameter) {
		String url = ADRESSE_SERVER + "ville/modifier";
		RequetePost post = new RequetePost();
		post.requetePost(url, urlParameter);
	}
	
	
	
}
