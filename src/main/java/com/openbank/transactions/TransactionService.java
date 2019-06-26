package com.openbank.transactions;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.openbank.transactions.beans.Transactions;

@Service
public class TransactionService implements ITransactionService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public Transactions getAll(String account) {
		
		String endpoint = "https://apisandbox.openbankproject.com/obp/v1.2.1/banks/rbs/accounts/" + account +" /public/transactions";

		Transactions transactions = restTemplate.getForObject(endpoint
				, Transactions.class);

		return transactions;
	}
	

}
