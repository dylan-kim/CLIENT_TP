package com.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class MeteoDTO {
	
	private String temperature;
	private String iconPath;
	
	public String iconRepoPath() {
		return "icons/" + this.iconPath +".png";
	}

}
