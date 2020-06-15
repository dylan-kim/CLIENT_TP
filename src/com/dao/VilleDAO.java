package com.dao;

import com.dto.VilleDTO;

public class VilleDAO {
	
	// Use Haversine formula
	// More informations here : https://www.movable-type.co.uk/scripts/latlong.html
	public double calculeDistance(VilleDTO villeA, VilleDTO villeB) {
		
        double latitudeA = Math.toRadians(Double.valueOf(villeA.getLatitude()));
        double longitudeA = Math.toRadians(Double.valueOf(villeA.getLongitude()));
        
        double latitudeB = Math.toRadians(Double.valueOf(villeB.getLatitude()));
        double longitudeB = Math.toRadians(Double.valueOf(villeB.getLongitude()));
        
        double deltaLatitude = latitudeB - latitudeA;
        double deltaLongitude = longitudeB - longitudeA;
        
        
        double a = Math.pow(Math.sin(deltaLatitude)/2, 2) + Math.cos(latitudeA)*Math.cos(latitudeB)*Math.pow(Math.sin(deltaLongitude)/2, 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        
        return Math.round(6371e3 * c * 10e-3);
	}

}
