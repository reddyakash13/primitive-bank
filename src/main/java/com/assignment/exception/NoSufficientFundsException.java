package com.assignment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.EXPECTATION_FAILED, reason="No sufficient funds to withdraw !! Please try a different amount")
public class NoSufficientFundsException extends Exception {

	private static final long serialVersionUID = -8414576666477265656L;

}
