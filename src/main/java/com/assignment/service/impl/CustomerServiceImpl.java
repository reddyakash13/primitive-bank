package com.assignment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.dto.CustomerDTO;
import com.assignment.entity.Customer;
import com.assignment.mapper.CustomerMapper;
import com.assignment.repository.CustomerRespository;
import com.assignment.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRespository repository;

	@Autowired
	private CustomerMapper mapper;

	@Override
	public CustomerDTO findById(Long id) {
		Customer entity = repository.findById(id).orElse(null);
		return mapper.convertEntityToDTO(entity);
	}

}
