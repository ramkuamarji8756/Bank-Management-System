package com.hospital.mgm.app.service;

import java.util.List;

import com.hospital.mgm.app.entity.Account;

public interface AccountService 
{
	public Account createAccount(Account account);
	public Account getAccountDetailsByAccountNumber(Long accountNumber);
	public List<Account> getAllAccountDetails();
	public Account depositAmount(Long accountNumber,Double amount);
	public Account withdrawAmount(Long accountNumber,Double amount);
	public void closeAccount(Long accountNumber);
	
	

}
