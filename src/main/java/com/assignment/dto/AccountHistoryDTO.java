package com.assignment.dto;

import java.time.ZonedDateTime;

import com.assignment.entity.Account;
import com.assignment.entity.TransactionType;

public class AccountHistoryDTO {

	private Long id;

	private TransactionType transactionType;

	private ZonedDateTime transactionTime;

	private Long openingBalance;

	private Long closingBalance;

	private Long transactionAmount;

	private Account account;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public ZonedDateTime getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(ZonedDateTime transactionTime) {
		this.transactionTime = transactionTime;
	}

	public Long getOpeningBalance() {
		return openingBalance;
	}

	public void setOpeningBalance(Long openingBalance) {
		this.openingBalance = openingBalance;
	}

	public Long getClosingBalance() {
		return closingBalance;
	}

	public void setClosingBalance(Long closingBalance) {
		this.closingBalance = closingBalance;
	}

	public Long getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Long transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}
