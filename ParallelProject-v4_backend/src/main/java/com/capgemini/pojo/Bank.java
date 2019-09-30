//Model class of User

package com.capgemini.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BankTable")
public class Bank {

	// Declaring attributes
	@Id

	@Column(name = "u_name")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "phone_no")
	private String contact_no;

	@Column(name = "email")
	private String email_id;

	@Column(name = "name")
	private String name;

	@Column(name = "u_balance")
	private double balance;

	@Override
	public String toString() {
		return "Bank [username=" + username + ", password=" + password + ", contact_no=" + contact_no + ", email_id="
				+ email_id + ", name=" + name + ", balance=" + balance + "]";
	}

	// Default constructor of User class
	public Bank() {
	}

	// Parameterized constructor of user class
	public Bank(String username, String password, String contact_no, String email_id, String name, double balance) {
		super();
		this.username = username;
		this.password = password;
		this.contact_no = contact_no;
		this.email_id = email_id;
		this.name = name;
		this.balance = balance;
	}

	// Getters and setters
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Bank(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContact_no() {
		return contact_no;
	}

	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
