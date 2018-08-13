package com.assignment.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.assignment.PrimitiveBankApplication;
import com.assignment.dto.AccountDTO;
import com.assignment.dto.AccountHistoryDTO;
import com.assignment.dto.Amount;
import com.assignment.entity.AccountType;
import com.assignment.entity.Currency;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PrimitiveBankApplication.class, webEnvironment = WebEnvironment.DEFINED_PORT)
public class AccountServiceTest {

	@Autowired
	private RestTemplate restTemplate;

	@Value("http://localhost:8080/v1/xyzbank")
	private String endPoint;

	@Test
	public void shouldFindAccountByCustomerId() {
		String url = endPoint + "/customer/1/account";

		AccountDTO account = restTemplate.getForObject(url, AccountDTO.class);

		assertThat(account)
			.hasFieldOrPropertyWithValue("accountNumber", 123414L)
			.hasFieldOrPropertyWithValue("accountType", AccountType.SAVINGS)
			.hasFieldOrPropertyWithValue("accountCurrency", Currency.EUR);
	}

	@Test
	public void shouldFindCurrentBalance() {
		String url = endPoint + "/customer/2/account/2/balance";

		Amount amount = restTemplate.getForObject(url, Amount.class);

		assertThat(amount)
			.hasFieldOrPropertyWithValue("currency", Currency.EUR)
			.hasFieldOrPropertyWithValue("value", 200L);
	}

	@Test
	public void shouldDepositAmountAndCheckBalance() {
		String depositUrl = endPoint + "/customer/1/account/1/deposit";

		restTemplate.postForLocation(depositUrl, new Amount(Currency.EUR, 100L));

		String url = endPoint + "/customer/1/account/1/balance";

		Amount amount = restTemplate.getForObject(url, Amount.class);

		assertThat(amount)
			.hasFieldOrPropertyWithValue("currency", Currency.EUR)
			.hasFieldOrPropertyWithValue("value", (80L + 100L));
	}

	@Test
	public void shouldWithdrawAmountAndCheckBalance() {
		String withdrawtUrl = endPoint + "/customer/3/account/3/withdraw";

		restTemplate.postForLocation(withdrawtUrl, new Amount(Currency.EUR, 134L));

		String url = endPoint + "/customer/3/account/3/balance";

		Amount amount = restTemplate.getForObject(url, Amount.class);

		assertThat(amount)
			.hasFieldOrPropertyWithValue("currency", Currency.EUR)
			.hasFieldOrPropertyWithValue("value", (400L - 134L));
	}

	@Test(expected = HttpClientErrorException.class)
	public void shouldValidateAmountWhileWithdrawing() {
		String depositUrl = endPoint + "/customer/1/account/1/withdraw";

		ResponseEntity<AccountHistoryDTO> response = restTemplate.postForEntity(depositUrl,
				new Amount(Currency.EUR, Long.MAX_VALUE), AccountHistoryDTO.class);

		Assert.assertEquals(HttpStatus.EXPECTATION_FAILED, response.getStatusCode());
	}
}
