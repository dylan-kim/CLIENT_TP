package com.api;

import com.dto.MeteoDTO;
import com.dto.VilleDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class test {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		// TODO Auto-generated method stub
		VilleAPI villeAPI = new VilleAPI();
		VilleDTO ville = villeAPI.trouverVille("01001");
		
		MeteoAPI meteoAPI = new MeteoAPI();
		MeteoDTO meteo = meteoAPI.getWeather(ville);
		System.out.println(meteo.getIconPath());
		System.out.println(meteo.getTemperature());
	}

}
