package com.assignment.dto;

import com.assignment.entity.Currency;

public class Amount {

	private Currency currency;
	private Long value;

	@SuppressWarnings("unused")
	private Amount() {
		// For jackson
	}
	public Amount(Currency currency, Long value) {
		super();
		this.currency = currency;
		this.value = value;
	}

	public Currency getCurrency() {
		return currency;
	}

	public Long getValue() {
		return value;
	}
}
