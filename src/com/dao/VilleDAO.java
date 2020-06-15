package com.dao;

import com.dto.VilleDTO;

public class VilleDAO {

	public double calculeDistance(VilleDTO villeA, VilleDTO villeB) {
		double distance = 0;
		double deltaLongitude = Double.valueOf(villeB.getLongitude()) - Double.valueOf(villeA.getLongitude());
		double deltaLatitude = Double.valueOf(villeB.getLatitude()) - Double.valueOf(villeA.getLatitude());
		distance = Math.sqrt(Math.pow(deltaLongitude, 2) + Math.pow(deltaLatitude, 2));
		return Math.round(distance);
	}

}
