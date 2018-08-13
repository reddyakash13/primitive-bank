package com.assignment.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.assignment.dto.AccountDTO;
import com.assignment.entity.Account;

@Component
public class AccountMapper {

	@Autowired
	private ModelMapper mapper;

	public AccountDTO convertEntityToDTO(Account account) {
		return mapper.map(account, AccountDTO.class);
	}
}
