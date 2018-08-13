package com.assignment.service.impl;

import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.dto.AccountHistoryDTO;
import com.assignment.entity.Account;
import com.assignment.entity.AccountHistory;
import com.assignment.entity.TransactionType;
import com.assignment.mapper.AccountHistoryMapper;
import com.assignment.repository.AccountHistoryRepository;
import com.assignment.repository.AccountRepository;
import com.assignment.service.AccountHistoryService;

@Service
public class AccountHistoryServiceImpl implements AccountHistoryService {

	@Autowired
	private AccountHistoryRepository repository;

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private AccountHistoryMapper mapper;

	@Override
	public AccountHistoryDTO createAccountHistory(Long accId, Long openBal, Long closingBal, Long transAmt, TransactionType type) {

		Optional<Account> account = accountRepository.findById(accId);

		if (account.isPresent()) {
			AccountHistory history = new AccountHistory();
			history.setId(Calendar.getInstance().getTimeInMillis());
			history.setAccount(account.get());
			history.setOpeningBalance(openBal);
			history.setClosingBalance(closingBal);
			history.setTransactionAmount(transAmt);
			history.setTransactionType(type);
			history.setTransactionTime(ZonedDateTime.now());
			repository.save(history);

			return mapper.convertEntityToDTO(history);
		}

		return null;
	}

}
