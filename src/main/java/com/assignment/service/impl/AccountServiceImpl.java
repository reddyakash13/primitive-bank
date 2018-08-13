package com.assignment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.dto.AccountDTO;
import com.assignment.dto.AccountHistoryDTO;
import com.assignment.dto.Amount;
import com.assignment.entity.Account;
import com.assignment.entity.TransactionType;
import com.assignment.exception.InvalidAccountNumberException;
import com.assignment.exception.NoSufficientFundsException;
import com.assignment.mapper.AccountMapper;
import com.assignment.repository.AccountRepository;
import com.assignment.service.AccountHistoryService;
import com.assignment.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository repository;

	@Autowired
	private AccountHistoryService accountHistoryService;

	@Autowired
	private AccountMapper accountMapper;

	@Override
	public AccountDTO findBycustomerId(Long custId) {
		Account account = repository.findBycustomerId(custId);
		return accountMapper.convertEntityToDTO(account);
	}

	@Override
	public Amount checkCurrentBalance(Long custId, Long accountId) throws InvalidAccountNumberException {
		Account account = repository.findById(accountId).orElse(null);
		if (account != null) {
			if (!account.getCustomer().getId().equals(custId)) {
				throw new InvalidAccountNumberException(accountId, custId);
			}
			return new Amount(account.getAccountCurrency(), account.getAccountBalance());
		}
		return null;
	}

	@Override
	public AccountHistoryDTO depositAmount(Long custId, Long accountId, Amount amount) throws InvalidAccountNumberException {
		Account account = repository.findById(accountId).orElse(null);
		if (account != null) {
			if (!account.getCustomer().getId().equals(custId)) {
				throw new InvalidAccountNumberException(accountId, custId);
			}
			Long openBal = account.getAccountBalance();
			Long closingBal = openBal + amount.getValue();
			account.setAccountBalance(closingBal);
			repository.save(account);

			return accountHistoryService.createAccountHistory(account.getId(), openBal, closingBal, amount.getValue(),
					TransactionType.CREDIT);
		}
		return null;
	}

	@Override
	public AccountHistoryDTO withdrawAmount(Long custId, Long accountId, Amount amount)
			throws NoSufficientFundsException, InvalidAccountNumberException {
		Account account = repository.findById(accountId).orElse(null);
		if (account != null) {
			if (!account.getCustomer().getId().equals(custId)) {
				throw new InvalidAccountNumberException(accountId, custId);
			}
			Long openBal = account.getAccountBalance();
			if (openBal < amount.getValue()) {
				throw new NoSufficientFundsException();
			}
			Long closingBal = openBal - amount.getValue();
			account.setAccountBalance(closingBal);
			repository.save(account);

			return accountHistoryService.createAccountHistory(account.getId(), openBal, closingBal, amount.getValue(),
					TransactionType.DEBIT);
		}
		return null;
	}
}
