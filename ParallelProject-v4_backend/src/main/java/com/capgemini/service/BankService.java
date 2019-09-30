//Service layer Interface

package com.capgemini.service;

import java.util.List;

import com.capgemini.pojo.Bank;
import com.capgemini.validation.PasswordValidation;
import com.capgemini.validation.UsernameException;

public interface BankService {

	public double showBalance(String username, String password); // To show balance

	public double deposit(String username, String password, double amount); // To deposit amount

	public double withdraw(String username, String password, double amount); // To withdraw money

	public double fundTransfer(String username, String password, double amount, String username1); // To transfer fund

	public List<String> printTransaction(String username); // Print transaction details

	// validation methods

	boolean validatePhone(String contact_no);

	public boolean validateBalance(double balance);

	public boolean validateUsername(String username) throws UsernameException;

	public boolean loginValidate(String username, String password1);

	public boolean validatePassword(String password) throws PasswordValidation;

	public void addUser(Bank bank);
	
	public List<Bank> findAll();

}
