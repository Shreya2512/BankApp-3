package com.capgemini.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.dao.BankApplicationDao;
import com.capgemini.dao.BankApplicationDaoImpl;
import com.capgemini.pojo.Transaction;
import com.capgemini.pojo.Bank;
import com.capgemini.validation.PasswordValidation;
import com.capgemini.validation.UsernameException;

@Service
public class BankServiceImpl implements BankService {

	BankApplicationDao dao = new BankApplicationDaoImpl();

	
	public void addUser(Bank bank) {
		dao.beginTransaction();
		dao.addUser(bank);
		dao.commitTransaction();
		
	}
	
	public double deposit(String username, String password, double amount) {

		dao.beginTransaction();
		double dep = dao.amt_deposit(username, password, amount);
		dao.commitTransaction();
		return dep;
	}

	
	public double withdraw(String username, String password, double amount) {

		dao.beginTransaction();
		double with = dao.amt_withdraw(username, password, amount);
		dao.commitTransaction();
		return with;
	}
	
	
	public double fundTransfer(String username, String password, double amount, String username1) {

		dao.beginTransaction();
		double result = dao.fund_Transfer(username, password, amount, username1);
		dao.commitTransaction();
		return result;
	}

	
	

	
	public double showBalance(String username, String password) {

		dao.beginTransaction();
		double balance = dao.get_Balance(username, password);
		dao.commitTransaction();
		return balance;
	}

	
	public List<String> printTransaction(String username) {
		
		dao.beginTransaction();
		List<String> list=dao.get_Transaction(username);
		 dao.commitTransaction();
		 return list;
	}

	
	public boolean validatePhone(String contact_no ) {
		
		boolean flag = false;
		char ch;
		if(contact_no.length()==10) {
		for (int i = 0; i < contact_no.length(); i++) {
			ch = contact_no.charAt(i);
			if (ch >= '1' && ch <= '9')
				flag = true;
		
		}
		
		
	}
		return flag;

}
	public boolean validateBalance(double balance) {
		
		boolean flag = true;
		if(balance<0)
			flag = false;
		return flag;
	}
	
	
	public  boolean validateUsername(String username) throws UsernameException {
		
		boolean flag = false;
		if (username.length() >= 6 && username.length() <= 12 && !username.contains(" "))

		{
			System.out.println("valid username");
		} else {
			flag = true;
			UsernameException u = new UsernameException(username);
			throw u;
		}
		return flag;
	}

	public  boolean validatePassword(String password) throws PasswordValidation {
		boolean flag = false;
		int flag1 = 0;
		int flag2 = 0;
		if (password.length() >= 5 && password.length() <= 10) {
			
			char ch;
			for (int i = 0; i < password.length(); i++) {
				ch = password.charAt(i);
				if (ch >= '1' && ch <= '9')
					flag1 = 1;
				if (ch >= 33 && ch <= 47 || ch >= 56 && ch <= 64 || ch >= 91 && ch <= 96 || ch >= 123 && ch <= 126)
					flag2 = 1;
			}
			if (flag1 == 1 && flag2 == 1)
				System.out.println("valid password");
		}
		 else {
			
			flag = true;
			PasswordValidation v = new PasswordValidation(password);
		 	
			throw v;
		}
		return flag;

	}
	
	public boolean loginValidate(String username,String password)
	{
		boolean flag=dao.loginValidate(username,password);
		return flag;
	}

	@Override
	public List<Bank> findAll() {
		dao.beginTransaction();
		List<Bank> list = dao.getAll();
		dao.commitTransaction();
		return list;
	}

	
	
	
}
