package com.assignment.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.assignment.dto.AccountHistoryDTO;
import com.assignment.entity.AccountHistory;

@Component
public class AccountHistoryMapper {

	@Autowired
	private ModelMapper mapper;

	public AccountHistoryDTO convertEntityToDTO(AccountHistory accountHistory) {
		return mapper.map(accountHistory, AccountHistoryDTO.class);
	}
}
