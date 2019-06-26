package com.openbank.transactions.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Account {
	
	private String id;
	private Holder holder;
	private String number;
	private AccountMetaData metadata;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Holder getHolder() {
		return holder;
	}
	public void setHolder(Holder holder) {
		this.holder = holder;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public AccountMetaData getMetadata() {
		return metadata;
	}
	public void setMetadata(AccountMetaData metadata) {
		this.metadata = metadata;
	}
	
		
}
