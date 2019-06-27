package com.openbank.transactions;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public List<BackBaseTransaction> getTransactions(@PathVariable String accountName)
    {
				
		Transactions transactions = transactionService.getAll(accountName);
		
		return transactions.getTransactions()
		.stream()
		.map(transaction -> modelMapper.map(transaction, BackBaseTransaction.class))
		.collect(Collectors.toList());
        
    }
	
	@GetMapping(path="{accountName}/transactions/{transactionType}", produces = "application/json")
    public List<BackBaseTransaction> getTransactionsOfType(@PathVariable String accountName, @PathVariable String transactionType)
    {
				
		Transactions transactions = transactionService.getAll(accountName);
		
		return transactions.getTransactions()
		.stream()
		.filter(transaction -> transactionType.equalsIgnoreCase(transaction.getDetails().getType()))
		.map(transaction -> modelMapper.map(transaction, BackBaseTransaction.class))
		.collect(Collectors.toList());
        
    }
	
	@GetMapping(path="{accountName}/transactions/{transactionType}/amount", produces = "application/json")
    public TotalAmount getAmount(@PathVariable String accountName, @PathVariable String transactionType)
    {
						
		Transactions transactions = transactionService.getAll(accountName);
		
		double totalAmount = transactions.getTransactions()
		.stream()
		.filter(transaction -> transactionType.equalsIgnoreCase(transaction.getDetails().getType()))
		.map(transaction -> transaction.getDetails().getValue().getAmount())
		.reduce(0d,Double::sum);
        
		return new TotalAmount(totalAmount);
		
    }
	
	
	
	 
}
