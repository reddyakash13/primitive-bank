package com.assignment.entity;

import java.time.ZonedDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "account")
public class Account {

	private Long id;

	private Long accountNumber;

	private AccountType accountType;

	private Customer customer;

	private ZonedDateTime createdOn;

	// private Set<AccountHistory> accountHistories;

	private Long accountBalance;

	private Currency accountCurrency;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column
	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "cust_id")
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Column(nullable = false)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	public ZonedDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(ZonedDateTime createdOn) {
		this.createdOn = createdOn;
	}

	/*@OneToMany(mappedBy = "account", orphanRemoval = true)
	@OrderBy("transactionTime asc")
	public Set<AccountHistory> getAccountHistories() {
		return accountHistories;
	}

	public void setAccountHistories(Set<AccountHistory> accountHistories) {
		this.accountHistories = accountHistories;
	}*/

	@Column
	public Long getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Long accountBalance) {
		this.accountBalance = accountBalance;
	}

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	public Currency getAccountCurrency() {
		return accountCurrency;
	}

	public void setAccountCurrency(Currency accountCurrency) {
		this.accountCurrency = accountCurrency;
	}
}
