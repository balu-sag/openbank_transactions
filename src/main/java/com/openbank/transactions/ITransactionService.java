package com.openbank.transactions;

import com.openbank.transactions.beans.Transactions;

public interface ITransactionService {
	
	public Transactions getAll(String account);
	
}
