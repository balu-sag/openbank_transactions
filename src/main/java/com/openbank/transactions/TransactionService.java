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
		// TODO Auto-generated method stub
		Transactions transactions = restTemplate.getForObject("https://apisandbox.openbankproject.com/obp/v1.2.1/banks/rbs/accounts/savings-kids-john/public/transactions"
				, Transactions.class);

		
		return transactions;
	}
	

}
