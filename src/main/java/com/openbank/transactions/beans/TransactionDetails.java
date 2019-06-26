package com.openbank.transactions.beans;

public class TransactionDetails {
	
	private String type;
	private String description;
	private Amount value;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Amount getValue() {
		return value;
	}
	public void setValue(Amount value) {
		this.value = value;
	}

	
}
