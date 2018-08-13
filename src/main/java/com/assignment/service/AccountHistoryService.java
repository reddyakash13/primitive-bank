package com.assignment.service;

import com.assignment.dto.AccountHistoryDTO;
import com.assignment.entity.TransactionType;

public interface AccountHistoryService {

	AccountHistoryDTO createAccountHistory(Long accId, Long openBal, Long closingBal, Long transAmt, TransactionType type);
}
