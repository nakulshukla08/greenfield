package com.db.awmd.challenge.repository;

import com.db.awmd.challenge.domain.Account;
import com.db.awmd.challenge.exception.DuplicateAccountIdException;
import com.db.awmd.challenge.exception.InsufficientFundException;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.stereotype.Repository;
@Slf4j
@Repository
public class AccountsRepositoryInMemory implements AccountsRepository {

	private final Map<String, Account> accounts = new ConcurrentHashMap<>();

	private Lock accountLock = new ReentrantLock();

	@Override
	public void createAccount(Account account) throws DuplicateAccountIdException {
		Account previousAccount = accounts.putIfAbsent(account.getAccountId(), account);
		if (previousAccount != null) {
			throw new DuplicateAccountIdException("Account id " + account.getAccountId() + " already exists!");
		}
	}

	@Override
	public Account getAccount(String accountId) {
		return accounts.get(accountId);
	}

	@Override
	public void clearAccounts() {
		accounts.clear();
	}

	@Override
	public void transferAmount(String fromAccountId, String toAccountId, BigDecimal amount)
			throws InsufficientFundException, InterruptedException {
		Account fromAccount = validateAccount(fromAccountId);
		Account toAccount = validateAccount(toAccountId);

		accountLock.lock();
		try {

			BigDecimal fromAccountBalance = getBalance(fromAccount);



			if (fromAccountBalance.compareTo(amount) == -1) {
				throw new InsufficientFundException(
						"Not enough balance in account : " + fromAccountId + " : " + fromAccountBalance);
			}

			fromAccount.withdraw(amount);
			toAccount.deposit(amount);

			String threadName = Thread.currentThread().getName();
			log.info(threadName + " transferred " + amount + " from " + fromAccountId + " to " + toAccountId
					+ ", Total amount in banks : " + getBalance(toAccount).add(getBalance(fromAccount)) + "\n");


		} finally {
			accountLock.unlock();
		}

	}

	private BigDecimal getBalance(Account account) {
		accountLock.lock();
		try {
			BigDecimal fromAccountBalance = account.getBalance();

			return fromAccountBalance;
		} finally {
			accountLock.unlock();
		}
	}

	private Account validateAccount(String accountId) {
		Account account = accounts.get(accountId);
		if (account == null) {
			throw new IllegalArgumentException("Invalid account id : " + accountId);
		}
		return account;
	}

}
