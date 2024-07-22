package com.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.model.Bank;
import com.web.repository.BankRepository;

@Service
public class BankServiceImpl implements BankService {
	
	@Autowired
	private BankRepository bankrepo;

	@Override
	public Bank newAccount(Bank bank) {
		bankrepo.save(bank);
		return bank;
	}

	@Override
	public Bank checkBalance(Bank bank) {
		long num = bank.getNum();
		String name = bank.getName();
		String password = bank.getPassword();

		Bank ban1 = bankrepo.findById(num).get();
		long num1 = ban1.getNum();
		String name1 = ban1.getName();
		String psw = ban1.getPassword();

		if (num == num1 && name.equals(name1) && password.equals(psw)) {
			return ban1;
		}
		else {
			return null;
	
		}
	}

	@Override
	public Bank Deposit(Bank bank) {
		long num = bank.getNum();
		String name = bank.getName();
		String password = bank.getPassword();
		double amount = bank.getAmount();

		Bank ban1 = bankrepo.findById(num).get();
		long num1 = ban1.getNum();
		String name1 = ban1.getName();
		String psw = ban1.getPassword();
		double amt = ban1.getAmount();

		
		if (num == num1 && name.equals(name1) && password.equals(psw)) {

			double Amount = ban1.getAmount() + amount;
			ban1.setAmount(Amount);
			bankrepo.save(ban1);
			return  ban1;
		} else {
			
			return null;
		}

	}

	@Override
	public Bank withdraw(Bank bank) {
		long num = bank.getNum();
		String name = bank.getName();
		String password = bank.getPassword();
		double amount = bank.getAmount();

		Bank ban2 = bankrepo.findById(num).get();

		String name1 = ban2.getName();
		String psw = ban2.getPassword();
		double amt = ban2.getAmount();
	
		if (name.equals(name1) && password.equals(psw)) {
			if (amt != 0.0 && amt >= amount) {
				double Amount1 = amt - amount;
				ban2.setAmount(Amount1);
				bankrepo.save(ban2);
				
				return ban2;
			}

		}
	
		return null;
	}

	@Override
	public Bank transfer(long num, String name, String password, long num1, String name1, double amount) {
		
		Bank bankk1 = bankrepo.findById(num).get();
		double b = bankk1.getAmount();
		Bank bankk2 = bankrepo.findById(num1).get();
		double b1 = bankk2.getAmount(); 
		
		if (bankk1 != null && bankk1.getAmount() > amount) {

			 	double Amount = bankk1.getAmount() - amount;
			 	
				double Amount1 = bankk2.getAmount() + amount;

				bankk1.setAmount(Amount);
				bankk2.setAmount(Amount1);
				bankrepo.save(bankk1);
				bankrepo.save(bankk2);
				
				return bankk2;
		}
		 else {
			return null;
		 }
	}

	@Override
	public Bank close() {
		
		return null;
	}

}
