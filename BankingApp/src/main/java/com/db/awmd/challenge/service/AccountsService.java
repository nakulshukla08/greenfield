package com.db.awmd.challenge.service;

import com.db.awmd.challenge.domain.Account;
import com.db.awmd.challenge.exception.ApplicationException;
import com.db.awmd.challenge.exception.InsufficientFundException;
import com.db.awmd.challenge.repository.AccountsRepository;
import lombok.Getter;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountsService {

	@Getter
	private final AccountsRepository accountsRepository;
	
	@Autowired
	private NotificationService notificationService;

	@Autowired
	public AccountsService(AccountsRepository accountsRepository) {
		this.accountsRepository = accountsRepository;
	}

	public void createAccount(Account account) {
		this.accountsRepository.createAccount(account);
	}

	public Account getAccount(String accountId) {
		return this.accountsRepository.getAccount(accountId);
	}

	public void transferAmount(String fromAccountId, String toAccountId, BigDecimal amount)
			throws InsufficientFundException, ApplicationException {
		try {
			this.accountsRepository.transferAmount(fromAccountId, toAccountId, amount);
			
			
			notificationService.notifyAboutTransfer(getAccount(toAccountId), "Your accout is credit with : "+amount);
			
			notificationService.notifyAboutTransfer(getAccount(fromAccountId), "Your accout is debited with : "+amount);

		} catch (InterruptedException e) {
			throw new ApplicationException("Something went wrong !");
		}
	}
}
