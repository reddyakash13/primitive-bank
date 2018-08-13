package com.assignment.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.assignment.dto.CustomerDTO;
import com.assignment.entity.Customer;

@Component
public class CustomerMapper {

	@Autowired
	private ModelMapper modelMapper;

	public CustomerDTO convertEntityToDTO(Customer customer) {
		CustomerDTO dto = modelMapper.map(customer, CustomerDTO.class);
		return dto;
	}
}
