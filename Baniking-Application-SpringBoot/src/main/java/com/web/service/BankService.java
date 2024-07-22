package com.web.service;

import com.web.model.Bank;

public interface BankService {
	Bank newAccount(Bank bank);
	public Bank checkBalance (Bank bank);
	public Bank Deposit(Bank bank);
	public Bank withdraw(Bank bank);
	public  Bank transfer(long num,String name,String password,long num1,String name1,double amount);
	public Bank close();
	

}
