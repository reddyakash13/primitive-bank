package com.assignment.service;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.assignment.PrimitiveBankApplication;
import com.assignment.dto.CustomerDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PrimitiveBankApplication.class, webEnvironment = WebEnvironment.DEFINED_PORT)
public class CustomerServiceTest {

	@Autowired
	private RestTemplate restTemplate;

	@Value("http://localhost:8080/v1/xyzbank")
	private String endPoint;

	@Test
	public void shouldFindCustomerById() {
		String url = endPoint + "/customer/1";
		CustomerDTO customer = restTemplate.getForObject(url, CustomerDTO.class);

		Assertions.assertThat(customer)
			.hasFieldOrPropertyWithValue("id", 1L)
			.hasFieldOrPropertyWithValue("name", "akash")
			.hasFieldOrPropertyWithValue("address", "142, wilson street")
			.hasFieldOrPropertyWithValue("emailAddress", "akash@xyz.com");
	}
}
