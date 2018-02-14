package com.db.awmd.challenge;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import com.anarsoft.vmlens.concurrent.junit.ConcurrentTestRunner;
import com.anarsoft.vmlens.concurrent.junit.ThreadCount;
import com.db.awmd.challenge.domain.Account;
import com.db.awmd.challenge.exception.InsufficientFundException;
import com.db.awmd.challenge.repository.AccountsRepositoryInMemory;

/**
 * Nakul Shukla
 */
@RunWith(ConcurrentTestRunner.class)
@SpringBootTest
public class AccountRepositoryTest {

	AccountsRepositoryInMemory accountRepository = new AccountsRepositoryInMemory();

	private final static int THREAD_COUNT = 10;

	@Before
	public void setup() {

		for (int i = 1; i <= THREAD_COUNT; i++) {
			Account account = new Account(String.valueOf(i));
			account.deposit(new BigDecimal(10000));

			accountRepository.createAccount(account);
		}

	}

	/*
	 *Test transferAmount method using a number of threads declared using THREAD_COUNT variable.
	 *
	 *Transfer amount between random accounts and by the end of test, check if total amount in all the accounts is still the same.
	 * 
	 */
	@Test
	@ThreadCount(THREAD_COUNT)
	public void testTransferAmount() {
		try {
			
			Random random = new Random();
			int fromAccount = random.nextInt(10);
			
			if(fromAccount == 0) return;
			
			int toAccount = random.nextInt(10);
			
			if(toAccount == 0 || fromAccount == toAccount) return;
			
			accountRepository.transferAmount(String.valueOf(fromAccount), String.valueOf(toAccount), new BigDecimal(500));


		} catch (InsufficientFundException | InterruptedException e) {

			System.out.println("exception : " + e.getMessage());
		}
	}

	@After
	public void checkBalance() {
		System.out.println("checking balance ..");

		BigDecimal totalAmount = BigDecimal.ZERO;
		for(int i = 1; i <= THREAD_COUNT; i++)
		{
			totalAmount = totalAmount.add(accountRepository.getAccount(String.valueOf(i)).getBalance());
		}

		System.out.println("account total amount : " + totalAmount);
		assertThat(totalAmount).isEqualByComparingTo(new BigDecimal(100000));
	}

}

