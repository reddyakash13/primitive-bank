package com.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.dto.AccountDTO;
import com.assignment.dto.AccountHistoryDTO;
import com.assignment.dto.Amount;
import com.assignment.dto.CustomerDTO;
import com.assignment.exception.InvalidAccountNumberException;
import com.assignment.exception.NoSufficientFundsException;
import com.assignment.service.AccountService;
import com.assignment.service.CustomerService;

@RestController
@RequestMapping("v1/xyzbank")
public class BankController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private AccountService accountService;

	@GetMapping(value = "/customer/{id}")
	public CustomerDTO findCustomerById(@PathVariable Long id) {
		return customerService.findById(id);
	}

	@GetMapping(value = "/customer/{id}/account")
	public AccountDTO findAccountDetailsForCustomer(@PathVariable(name = "id") Long custId) {
		return accountService.findBycustomerId(custId);
	}

	@GetMapping(value = "/customer/{id}/account/{accId}/balance")
	public Amount getBalanceForAccount(@PathVariable(name = "id") Long custId, @PathVariable Long accId)
			throws InvalidAccountNumberException {
		return accountService.checkCurrentBalance(custId, accId);
	}

	@PostMapping(value = "/customer/{id}/account/{accId}/deposit")
	public AccountHistoryDTO depositAmount(@PathVariable(name = "id") Long custId, @PathVariable Long accId,
			@RequestBody Amount amount) throws InvalidAccountNumberException {
		return accountService.depositAmount(custId, accId, amount);
	}

	@PostMapping(value = "/customer/{id}/account/{accId}/withdraw")
	public ResponseEntity<AccountHistoryDTO> withdrawAmount(@PathVariable(name = "id") Long custId, @PathVariable Long accId,
			@RequestBody Amount amount) throws NoSufficientFundsException, InvalidAccountNumberException {
		try {
			AccountHistoryDTO response = accountService.withdrawAmount(custId, accId, amount);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (NoSufficientFundsException | InvalidAccountNumberException e) {
			throw e;
		}
	}
}
