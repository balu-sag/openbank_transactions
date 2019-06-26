package com.openbank.transactions;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openbank.transactions.beans.Transactions;

@RestController
@RequestMapping(path = "/accounts")
public class TransactionsController {
	
	@Autowired
	ITransactionService transactionService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping(path="{accountName}/transactions", produces = "application/json")
    public List<BackBaseTransaction> getTransactions(String accountName)
    {
		
		Transactions transactions = transactionService.getAll(accountName);
		
		
		
		return transactions.getTransactions()
		.stream()
		.map(transaction -> modelMapper.map(transaction, BackBaseTransaction.class))
		.collect(Collectors.toList());
        
    }
	
	 
}
