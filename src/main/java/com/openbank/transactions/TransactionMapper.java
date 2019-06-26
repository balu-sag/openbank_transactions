package com.openbank.transactions;

import org.modelmapper.PropertyMap;

import com.openbank.transactions.beans.Transaction;

public class TransactionMapper extends PropertyMap<Transaction, BackBaseTransaction> {

	@Override
	protected void configure() {
		map(source.getId(), destination.getId());
		map(source.getThisAccount().getId(), destination.getAccountId());
		map(source.getOtherAccount().getNumber(),destination.getCounterpartyAccount());
		map(source.getOtherAccount().getHolder().getName(), destination.getCounterpartyName());
		map(source.getDetails().getValue().getAmount(), destination.getInstructedAmount());
		map(source.getDetails().getValue().getCurrency(), destination.getInstructedCurrency());
		map(source.getDetails().getValue().getAmount(), destination.getTransactionAmount());
		map(source.getDetails().getValue().getCurrency(), destination.getTransactionCurrency());
		map(source.getDetails().getType(), destination.getTransactionType());
		map(source.getDetails().getDescription(), destination.getDescription());
	}

}
