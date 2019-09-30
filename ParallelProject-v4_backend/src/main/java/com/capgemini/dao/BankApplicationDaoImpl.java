//Dao layer interface

package com.capgemini.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.exceptions.TechnicalException;
import com.capgemini.pojo.Bank;
import com.capgemini.pojo.Transaction;

@Repository
public class BankApplicationDaoImpl implements BankApplicationDao {
	
	List<String> list = new ArrayList<String>();
	String str1;

	double bal;
	String str;
	private EntityManager em;

	public BankApplicationDaoImpl() {

		em = JPAUtil.getEntityManager();
	}

	Bank bank = new Bank();

	public void beginTransaction() {
		em.getTransaction().begin();
	}

	public void commitTransaction() {
		em.getTransaction().commit();
	}

	// Implementing methods of DAO interface by overriding

	// Method to retrieve balance

	public double get_Balance(String username, String password) {

		Bank bank = em.find(Bank.class, username);
		double balance = bank.getBalance();
		return balance;
	}

	// Method to deposit money in account

	public double amt_deposit(String username, String password, double amount) {

		Bank bank = em.find(Bank.class, username);
		double balance = bank.getBalance();
		bal = balance + amount;
		bank.setBalance(bal);
		str="Amount"+amount+"has been successfully deposited";
		list.add(str1);
		return bal;

	}

	// Method to withdraw money

	public double amt_withdraw(String username, String password, double amount) {

		Bank bank = em.find(Bank.class, username);
		double balance = bank.getBalance();

		if (balance > amount) {
			bal = balance - amount;
			bank.setBalance(bal);
		} else
			System.out.println("Low balance");
		str="Amount"+amount+"has been successfully withdrawn";
		list.add(str1);
		return bal;

	}

	// Method to transfer fund to another account

	public double fund_Transfer(String username, String password, double amount, String username1) {

		boolean flag = false;
		Bank bank = em.find(Bank.class, username);
		double balance = bank.getBalance();
		if (balance > amount) {
			flag = true;
			bal = balance - amount;
			bank.setBalance(bal);
		} else
			System.out.println("Low balance");
		Bank bank2 = em.find(Bank.class, username);
		double balance2 = bank2.getBalance();
		double bal2 = balance + amount;
		bank2.setBalance(bal2);
		str="Amount"+amount+"has been successfully tranferred";
		list.add(str1);
		return bal;

	}

	// To print transaction details

	public List<String> get_Transaction(String username) {
		return list;
	}

	// to validate login details

	public boolean loginValidate(String username, String password) {

		boolean result=true;
		Bank user=em.find(Bank.class,username);
		String pass=user.getPassword();
		if(user.equals(null))
			result=false;
		else
		{
			if(pass.equals(password))
				result=true;
		}
		return result;
	}

	public void addUser(Bank bank) {
		em.persist(bank);

	}

	@Override
	public List<Bank> getAll() {
		String query = "From BankTable";
		TypedQuery<Bank> tquery = em.createQuery(query, Bank.class);
		List<Bank> list = tquery.getResultList();
		return list;
	}

}
