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
	
	@Autowired
	private OpenBankProperties openBankProperties;
	
	@Override
	public Transactions getAll(String account) {
		
		String url = String.format("%s/obp/v1.2.1/banks/rbs/accounts/%s/public/transactions", openBankProperties.getHost(), account);
		
		Transactions transactions = restTemplate.getForObject(url
				, Transactions.class);

		return transactions;
	}
	

}
