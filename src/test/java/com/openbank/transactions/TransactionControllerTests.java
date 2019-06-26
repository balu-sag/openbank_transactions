package com.openbank.transactions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.AssertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.openbank.transactions.beans.Amount;
import com.openbank.transactions.beans.Transaction;
import com.openbank.transactions.beans.TransactionDetails;
import com.openbank.transactions.beans.Transactions;

@RunWith(MockitoJUnitRunner.class)
public class TransactionControllerTests {
	
	@Mock
	private ITransactionService transactionService;
	
	@InjectMocks
	private TransactionsController transactionsController;
	
	@Before
	public void setup(){
	    MockitoAnnotations.initMocks(this);
	}
	
	@Test
    public void should_return_total_amount(){
		
		Mockito.when(transactionService.getAll("test")).thenReturn(prepareTransactionData());
		
		TotalAmount amount = transactionsController.getAmount("test", "transtype1");
		
		assertTrue(amount.getAmount() == 30.0);		
		
    }


	public Transactions prepareTransactionData() {
		Transactions transactions = new Transactions();
		
		Transaction t1 = new Transaction();
		TransactionDetails td1 = new TransactionDetails();
		td1.setValue(new Amount("GBP", 10.0));
		td1.setType("transtype1");
		t1.setDetails(td1);
		transactions.transactions.add(t1);
		
		Transaction t2 = new Transaction();
		TransactionDetails td2 = new TransactionDetails();
		td2.setValue(new Amount("GBP", 20.0));
		td2.setType("transtype1");
		t2.setDetails(td2);
		transactions.transactions.add(t2);
		
		Transaction t3 = new Transaction();
		TransactionDetails td3 = new TransactionDetails();
		td3.setValue(new Amount("GBP", 20.0));
		td3.setType("transtype2");
		t3.setDetails(td3);
		transactions.transactions.add(t3);
		
		return transactions;
	}

}
