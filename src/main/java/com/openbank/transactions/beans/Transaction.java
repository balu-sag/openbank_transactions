package com.openbank.transactions.beans;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Transaction {
	
	private String id;
	
	@JsonProperty("this_account")
	private Account thisAccount;
	
	@JsonProperty("other_account")
	private Account otherAccount;
	
	private TransactionDetails details;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Account getThisAccount() {
		return thisAccount;
	}

	public void setThisAccount(Account thisAccount) {
		this.thisAccount = thisAccount;
	}

	public Account getOtherAccount() {
		return otherAccount;
	}

	public void setOtherAccount(Account otherAccount) {
		this.otherAccount = otherAccount;
	}

	public TransactionDetails getDetails() {
		return details;
	}

	public void setDetails(TransactionDetails details) {
		this.details = details;
	}
	
	
	
}
