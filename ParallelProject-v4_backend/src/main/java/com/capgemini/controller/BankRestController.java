package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.pojo.Bank;
import com.capgemini.service.BankService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="users")
public class BankRestController {
	@Autowired
	private BankService service;

	// http://localhost:9090/users/
	@RequestMapping(value="/", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public void addUser(@RequestBody Bank bank)
	{
		service.addUser(bank);
	}
	// http://localhost:9090/users/
		@RequestMapping(value="/", method=RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_VALUE)
		public void findAllUsers()
		{
			service.findAll();
		}
	// http://localhost:9090/users/shreya25/2512@shreya
	@RequestMapping(value="/{username}/{password}", method=RequestMethod.GET)
	public double getBalance(@PathVariable("username")String uname,@PathVariable("password")String pass)
	{
		double bal=service.showBalance(uname,pass);
		return bal;
	}
	// http://localhost:9090/users/shreya25/2512@shreya/5000
	@RequestMapping(value="/deposit/{username}/{password}/{amount}", method=RequestMethod.GET)
	public double deposit(@PathVariable("username")String uname,@PathVariable("password")String pass,@PathVariable("amount")Double amt)
	{
		double bal=service.deposit(uname, pass, amt);
		return bal;
	}
	
	// http://localhost:9090/users/shreya25/2512@shreya/5000
	@RequestMapping(value="/withdraw/{username}/{password}/{amount}", method=RequestMethod.GET)
	public double withdraw(@PathVariable("username")String uname,@PathVariable("password")String pass,@PathVariable("amount")Double amt)
	{
		double bal=service.withdraw(uname, pass, amt);
		return bal;
	}
	
	// http://localhost:9090/users/shreya25/2512@shreya/5000/mansi12
	@RequestMapping(value="/transfer/{username}/{password}/{amount}/{username1}", method=RequestMethod.GET)
	public double transfer(@PathVariable("username")String uname,@PathVariable("password")String pass,@PathVariable("amount")Double amt,@PathVariable("username1")String uname1)
	{
		 return service.fundTransfer(uname, pass, amt,uname1);
		 
	}
	
	// http://localhost:9090/users/shreya25/2512@shreya
		@RequestMapping(value="/check/{username}/{password}", method=RequestMethod.GET)
		public boolean login(@PathVariable("username")String uname,@PathVariable("password")String pass)
		{
			boolean result=service.loginValidate(uname,pass);
			return result;
		}
		
		// http://localhost:9090/users/shreya25/2512@shreya
				@RequestMapping(value="/print/{username}", method=RequestMethod.GET)
				public List<String> print(@PathVariable("username")String uname)
				{
					List<String> result=service.printTransaction(uname);
					return result;
				}
	
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            