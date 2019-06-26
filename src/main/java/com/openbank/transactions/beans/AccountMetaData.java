package com.openbank.transactions.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountMetaData {
	
	@JsonProperty("image_URL")
	private String imageUrl;

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
	

}
