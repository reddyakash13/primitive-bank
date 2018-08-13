package com.assignment.entity;

import java.time.ZonedDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "accounthistory")
public class AccountHistory {

	private Long id;

	private TransactionType transactionType;

	private ZonedDateTime transactionTime;

	private Long openingBalance;

	private Long closingBalance;

	private Long transactionAmount;

	private Account account;

	@Id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	@Column(nullable = false)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	public ZonedDateTime getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(ZonedDateTime transactionTime) {
		this.transactionTime = transactionTime;
	}

	@Column
	public Long getOpeningBalance() {
		return openingBalance;
	}

	public void setOpeningBalance(Long openingBalance) {
		this.openingBalance = openingBalance;
	}

	@Column
	public Long getClosingBalance() {
		return closingBalance;
	}

	public void setClosingBalance(Long closingBalance) {
		this.closingBalance = closingBalance;
	}

	@Column
	public Long getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Long transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id", nullable = false)
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof AccountHistory))
			return false;
		return id != null && id.equals(((AccountHistory) obj).id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.account, this.closingBalance, this.openingBalance, this.transactionAmount,
				this.transactionTime, this.transactionType);
	}
}
