package com.assignment.service;

import com.assignment.dto.AccountDTO;
import com.assignment.dto.AccountHistoryDTO;
import com.assignment.dto.Amount;
import com.assignment.exception.InvalidAccountNumberException;
import com.assignment.exception.NoSufficientFundsException;

public interface AccountService {

	AccountDTO findBycustomerId(Long custId);

	Amount checkCurrentBalance(Long custId, Long accountId) throws InvalidAccountNumberException;

	AccountHistoryDTO depositAmount(Long custId, Long accountId, Amount amount) throws InvalidAccountNumberException;

	AccountHistoryDTO withdrawAmount(Long custId, Long accountId, Amount amount) throws NoSufficientFundsException, InvalidAccountNumberException;
}
