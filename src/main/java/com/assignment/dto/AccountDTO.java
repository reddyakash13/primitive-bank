package com.assignment.dto;

import java.time.ZonedDateTime;

import com.assignment.entity.AccountType;
import com.assignment.entity.Currency;
import com.assignment.entity.Customer;

public class AccountDTO {

	private Long id;

	private Long accountNumber;

	private AccountType accountType;

	private Customer customer;

	private Currency accountCurrency;

	private ZonedDateTime createdOn;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ZonedDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(ZonedDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public Currency getAccountCurrency() {
		return accountCurrency;
	}

	public void setAccountCurrency(Currency accountCurrency) {
		this.accountCurrency = accountCurrency;
	}
}
