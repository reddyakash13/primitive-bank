package com.assignment.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MapperHelper {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
