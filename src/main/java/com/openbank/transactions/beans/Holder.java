package com.openbank.transactions.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Holder {
	
	private String name;
	
	@JsonProperty("is_alias")
	private boolean isAlias;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isAlias() {
		return isAlias;
	}
	public void setAlias(boolean isAlias) {
		this.isAlias = isAlias;
	}
	
}
