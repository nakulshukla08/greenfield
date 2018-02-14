package com.db.awmd.challenge.web;

import com.db.awmd.challenge.domain.Account;
import com.db.awmd.challenge.exception.ApplicationException;
import com.db.awmd.challenge.exception.DuplicateAccountIdException;
import com.db.awmd.challenge.exception.InsufficientFundException;
import com.db.awmd.challenge.service.AccountsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.math.BigDecimal;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/accounts")
@Slf4j
@Api(value = "/v1/accounts")
public class AccountsController {

	private final AccountsService accountsService;

	@Autowired
	public AccountsController(AccountsService accountsService) {
		this.accountsService = accountsService;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Create a new account")
	public ResponseEntity<Object> createAccount(@RequestBody @Valid Account account) {
		log.info("Creating account {}", account);

		try {
			this.accountsService.createAccount(account);
		} catch (DuplicateAccountIdException daie) {
			return new ResponseEntity<>(daie.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping(path = "/{accountId}")
	@ApiOperation(value = "Get account details by ID")
	public Account getAccount(@PathVariable String accountId) {
		log.info("Retrieving account for id {}", accountId);
		return this.accountsService.getAccount(accountId);
	}

	@GetMapping(path = "/transfer")
	@ApiOperation(value = "Transfer amount")
	public void transferAmount(@RequestParam String fromAccountId, @RequestParam String toAccountId,
			@RequestParam BigDecimal amount) throws InsufficientFundException, ApplicationException {
		log.info("Transfer amount from {} to {} ", fromAccountId, toAccountId);
		this.accountsService.transferAmount(fromAccountId, toAccountId, amount);

	}

}
