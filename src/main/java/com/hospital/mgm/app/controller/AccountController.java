package com.hospital.mgm.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.mgm.app.entity.Account;
import com.hospital.mgm.app.service.AccountService;

@RestController 
public class AccountController 
{
	@Autowired
	AccountService accountService;
	
	@PostMapping("/create")
	public ResponseEntity<Account> createAccount( @RequestBody Account account) 
	{
		Account createdAccount =accountService.createAccount(account);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdAccount);
	}
	

	@GetMapping("/{accountNumber}")
	public Account getAccountByAccountNumber(@PathVariable Long accountNumber)
	{
	Account	account=accountService.getAccountDetailsByAccountNumber(accountNumber);
		return account;
	}
	
	@GetMapping("/getAllAccount")
	public List<Account> getAllAccountDetails()
	{
		List<Account> allAccounts = accountService.getAllAccountDetails();
		return allAccounts;
	}
	
	@PutMapping("/deposit/{accounNumber}/{amount}")
	public Account depositAccount(@PathVariable Long accounNumber, @PathVariable Double amount) 
	{
		 Account account = accountService.depositAmount(accounNumber, amount);
		
		return account;
		}
	
	@PutMapping("/withdraw/{accounNumber}/{amount}")
	public Account withdrawAccount(@PathVariable Long accounNumber, @PathVariable Double amount) 
	{
		 Account account = accountService.withdrawAmount(accounNumber, amount);
		
		return account;
		}
	
	@DeleteMapping("/delete/{accountNumber}")
	public ResponseEntity<String> deleteAccount(@PathVariable Long accountNumber) 
	{
		accountService.closeAccount(accountNumber);
		
		return  ResponseEntity.status(HttpStatus.NO_CONTENT).body("Account closed");
	}
	
}
