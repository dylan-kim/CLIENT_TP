package com.api;

import org.json.JSONArray;
import org.json.JSONObject;

import com.dto.MeteoDTO;
import com.dto.VilleDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.util.RequeteGet;

// Utilisation de l'API : https://openweathermap.org/api
public class MeteoAPI {
	
	public static final String API_KEY = "YOUR_API_KEY";
	
	
	public MeteoDTO getWeather(VilleDTO ville) throws JsonMappingException, JsonProcessingException {
		String url = "http://api.openweathermap.org/data/2.5/weather?lat=" + ville.getLatitude() + "&lon=" + ville.getLongitude() + "&appid=" + API_KEY;
		
		RequeteGet get = new RequeteGet();		
		String jsonString = get.requeteGet(url);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		JSONObject jsonObj = new JSONObject(jsonString);
		JSONArray weather = jsonObj.getJSONArray("weather");
		JSONObject main = jsonObj.getJSONObject("main");

		MeteoDTO meteo = createMeteo(weather, main);
		return meteo;
		
	}


	private MeteoDTO createMeteo(JSONArray weather, JSONObject main) {
		MeteoDTO meteo = new MeteoDTO();
		meteo.setIconName(weather.getJSONObject(0).getString("icon"));
		
		double tempDegreCelsius = Math.round((double) main.get("temp") - 273.15);
		meteo.setTemperature(String.valueOf(tempDegreCelsius));
		return meteo;
	}
	

}
