package com.openbank.transactions;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import com.openbank.transactions.beans.Transaction;

public class TransactionMapTests {

	
	private ModelMapper modelMapper;
	
	@Before
    public void setup(){
        modelMapper = new ModelMapper();
        modelMapper.addMappings(new TransactionMapper());
    }
	
	@Test
    public void map_ShouldValidate_IfObjectsValid(){
		Transaction transaction = prepareTransaction();

        BackBaseTransaction backBaseTransaction =
            modelMapper.map(transaction, BackBaseTransaction.class);

        modelMapper.validate();

        assertEquals(
        		transaction.getId(), backBaseTransaction.getId());
    }
	
	public Transaction prepareTransaction()
	{
		Transaction transaction = new Transaction();
		
		
		transaction.setId("123");
		
		return transaction;
		
	}
	
}
