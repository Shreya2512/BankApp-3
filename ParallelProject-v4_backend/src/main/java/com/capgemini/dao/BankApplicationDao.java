// Dao Interface 

package com.capgemini.dao;

import java.util.List;

import com.capgemini.pojo.Bank;

public interface BankApplicationDao {

	// Declaration of methods

	public double get_Balance(String username, String password);

	public double amt_deposit(String username, String password, double amount);

	public double amt_withdraw(String username, String password, double amount);

	public double fund_Transfer(String username, String password, double amount, String username1);

	public List<String> get_Transaction(String username);

	public boolean loginValidate(String username, String password);

	public void beginTransaction();

	public void commitTransaction();

	public void addUser(Bank bank);

	public List<Bank> getAll();
}
