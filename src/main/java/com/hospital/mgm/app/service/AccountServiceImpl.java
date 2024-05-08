package com.hospital.mgm.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.mgm.app.entity.Account;
import com.hospital.mgm.app.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService
{
	@Autowired
	AccountRepository repo;

	@Override
	public Account createAccount(Account account) {
	Account accountSaved=	repo.save(account);
		return accountSaved;
	}

	@Override
	public Account getAccountDetailsByAccountNumber(Long accountNumber) {
		Optional<Account> account = repo.findById(accountNumber);
	if(account.isEmpty()) 
	{
		throw new RuntimeException("Account is Not Present!!! ");
	}
	Account account_found=account.get();
		return account_found;
	}

	@Override
	public List<Account> getAllAccountDetails() {
	List<Account> listOfAaccount = repo.findAll();
		return listOfAaccount;
	}

	@Override
	public Account depositAmount(Long accountNumber, Double amount) {
		Optional<Account> account = repo.findById(accountNumber);
		if(account.isEmpty()) 
		{
			throw new RuntimeException("Account is not Existed...");
		}
		Account accountPresent=account.get();
		Double totalBalance = accountPresent.getAccount_balance()+amount;
		accountPresent.setAccount_balance(totalBalance);
		repo.save(accountPresent);
	//	System.out.println("Amount Added"+"        "+amount+"   "+ totalBalance);
		return accountPresent;
	}

	@Override
	public Account withdrawAmount(Long accountNumber, Double amount) {
	Optional<Account> account = repo.findById(accountNumber);
		if(account.isEmpty()) 
		{
			throw new RuntimeException(" Account is not Existed!!!!");
			
		}
		Account accountPresent= account.get();
		
		Double accountBalance = accountPresent.getAccount_balance()-amount;
		 accountPresent.setAccount_balance(accountBalance);
		repo.save(accountPresent);
		return accountPresent;
	}

	@Override
	public void closeAccount(Long accountNumber) {
		getAccountDetailsByAccountNumber(accountNumber);
		repo.deleteById(accountNumber);
		
	}

}
