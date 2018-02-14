package com.db.awmd.challenge.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class Account {

	@NotNull
	@NotEmpty
	private final String accountId;

	@NotNull
	@Min(value = 0, message = "Initial balance must be positive.")
	private BigDecimal balance;


	public Account(String accountId) {
		this.accountId = accountId;
		this.balance = BigDecimal.ZERO;
	}
	


	@JsonCreator
	public Account(@JsonProperty("accountId") String accountId, @JsonProperty("balance") BigDecimal balance) {
		this.accountId = accountId;
		this.balance = balance;
	}

/*	public BigDecimal getBalance() {
		accountLock.lock();
		System.out.println("Thread acquired lock : "+Thread.currentThread().getName());
		try {
			return this.balance;
		} finally {
			System.out.println("Releasing lock : "+Thread.currentThread().getName());
			accountLock.unlock();
		}
	}
	
	public void setBalance(BigDecimal balance)
	{
		accountLock.lock();
		System.out.println("Thread acquired lock : "+Thread.currentThread().getName());
		
		try
		{
			this.balance= balance;
		}
		finally
		{
			System.out.println("Releasing lock : "+Thread.currentThread().getName());
			accountLock.unlock();
		}
	}*/

	public void withdraw(BigDecimal amount) {
		balance = balance.subtract(amount);
	}

	public void deposit(BigDecimal amount) {
		balance = balance.add(amount);
	}
}
