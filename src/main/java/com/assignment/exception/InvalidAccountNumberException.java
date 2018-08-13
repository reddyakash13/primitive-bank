package com.assignment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidAccountNumberException extends Exception {

	private static final long serialVersionUID = -7554172861119313230L;

	public InvalidAccountNumberException(Long accountId, Long custId) {
		super("No account number " + accountId + " was found for customer id " + custId);
	}
}
