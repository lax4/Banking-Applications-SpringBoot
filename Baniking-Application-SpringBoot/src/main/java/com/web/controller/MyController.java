package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.model.Bank;
import com.web.service.BankService;

@Controller
public class MyController {
	@Autowired
	private BankService bankService;
	
@RequestMapping("/")
public String homeForm() {
	return "home";
}

@RequestMapping("/newacc")
public String newAcc(Bank bank, ModelMap model) {

	model.put("ban", bank);
	return "newaccount";
}
	@RequestMapping("/newAccUpdate")
//	@ResponseBody
	public String newacc(@ModelAttribute Bank bank) {
		Bank ba = bankService.newAccount(bank);
		String message = null;
		if (ba != null) {
			return "success";
		} else {
			message = "data not inserted";
		}

		return message;
	}

	@RequestMapping("/bal")
	public String balance(Bank bank, ModelMap model) {

		model.put("ban", bank);
		return "balance";
	}

	@RequestMapping("/balance")
	public String balance1(@ModelAttribute Bank bank, ModelMap model) {

		Bank ba =  bankService.checkBalance(bank);
		model.put("bank1", ba);

		return "viewbalance";

	}

	@RequestMapping("/depo")
	public String deposit(Bank bank, ModelMap model) {

		model.put("ban", bank);
		return "deposit";
	}

	@RequestMapping("/deposit")
	public String depositt(@ModelAttribute Bank bankk, ModelMap model) {

		Bank ba =  bankService.Deposit(bankk);
		model.put("bank1", ba);

		return "viewdepositbal";

	}

	@RequestMapping("/with")
	public String withdreww(Bank bank, ModelMap model) {

		model.put("ban", bank);
		return "withdrawform";
	}

	@RequestMapping("/withdrew")
	public String withdrew(@ModelAttribute Bank bankk, ModelMap model) {

		Bank ba =  bankService.withdraw(bankk);
		model.put("bank2", ba);

		return "viewwithdrawbal";

	}

	@RequestMapping("/transferform1")
	public String tranferr(Bank bank, ModelMap model) {

		model.put("ban", bank);
		return "transferform1";
	}

	@RequestMapping("/transfer")
	public String trasfer(@RequestParam long num, @RequestParam String name, @RequestParam String password,
			@RequestParam long num1, @RequestParam String name1, @RequestParam double amount, Bank bank,
			ModelMap model) {

		Bank ba =  bankService.transfer(num, name, password, num1, name1, amount);
		model.put("bank3", ba);

		return "viewtransfer";

	}


}
