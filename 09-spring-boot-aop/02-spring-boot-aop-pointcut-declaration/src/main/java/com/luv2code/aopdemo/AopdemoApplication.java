package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MemberShipDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO,
											   MemberShipDAO memberShipDAO,
											   TrafficFortuneService trafficFortuneService) {
		return runner -> {
			// @BeforeAdvice: run before method
			// demoTheBeforeAdvice(accountDAO, memberShipDAO);
			
			// @AfterReturning: run after method (success)
			// demoTheAfterReturningAdvice(accountDAO);
			
			// @AfterThrowing: run after method when there are exception
			// demoTheAfterThrowingAdvice(accountDAO);
			
			// @After: always run even though success or exception
			// demoAfterAdvice(accountDAO);
			
			// @Around: run before and after method
			// demoAroundAdvice(trafficFortuneService);
			
			// demoTheAroundAdviceHandleException(trafficFortuneService);
			
			demoTheAroundAdviceReThrowException(trafficFortuneService);
			
		};
	}
	
	private void demoTheAroundAdviceReThrowException(TrafficFortuneService trafficFortuneService) {
		System.out.println("\nMain program: demoTheAroundAdviceReThrowException");
		
		System.out.println("Calling getFortune()");
		
		boolean stripWire = true;
		String data = trafficFortuneService.getFortune(stripWire);
		
		System.out.println("\nMy fortune is: " + data);
		
		System.out.println("Finished");
	}
	
	private void demoTheAroundAdviceHandleException(TrafficFortuneService trafficFortuneService) {
		System.out.println("\nMain program: demoTheAroundAdviceHandleException");
		
		System.out.println("Calling getFortune()");
		
		boolean stripWire = true;
		String data = trafficFortuneService.getFortune(stripWire);
		
		System.out.println("\nMy fortune is: " + data);
		
		System.out.println("Finished");
	}
	
	private void demoAroundAdvice(TrafficFortuneService trafficFortuneService) {
		System.out.println("\nMain program: demoAroundAdvice");
		
		System.out.println("Calling getFortune()");
		
		String data = trafficFortuneService.getFortune();
		
		System.out.println("\nMy fortune is: " + data);
		
		System.out.println("Finished");
		
	}
	
	private void demoAfterAdvice(AccountDAO accountDAO) {
		// gets list of Account
		List<Account> accounts = null;
		
		try {
			// add boolean flag
			boolean stripWire = true;
			accounts = accountDAO.findAccounts(stripWire); // throw exception if stripWire = true
		} catch (Exception exc) {
			System.out.println("\n\nMain program: caught exception: " + exc);
		}
		
		// display Accounts
		System.out.println("\n\nMain program: demoTheAfterThrowingAdvice");
		System.out.println("-------------------");
		
		System.out.println(accounts);
		
		System.out.println("\n");
	}
	
	private void demoTheAfterThrowingAdvice(AccountDAO accountDAO) {
		// gets list of Account
		List<Account> accounts = null;
		
		try {
			// add boolean flag
			boolean stripWire = true;
			accounts = accountDAO.findAccounts(stripWire); // throw exception if stripWire = true
		} catch (Exception exc) {
			System.out.println("\n\nMain program: caught exception: " + exc);
		}
		
		// display Accounts
		System.out.println("\n\nMain program: demoTheAfterThrowingAdvice");
		System.out.println("-------------------");
		
		System.out.println(accounts);
		
		System.out.println("\n");
	}
	
	private void demoTheAfterReturningAdvice(AccountDAO accountDAO) {
		// gets list of Account
		List<Account> accounts = accountDAO.findAccounts();
		
		// display Accounts
		System.out.println("\n\nMain program: demoTheAfterReturningAdvice");
		System.out.println("-------------------");
		
		System.out.println(accounts);
		
		System.out.println("\n");
	}
	
	private void demoTheBeforeAdvice(AccountDAO accountDAO, MemberShipDAO memberShipDAO) {
		Account account = new Account();
		account.setName("Test");
		account.setLevel("Basic");
		
		// call the Account business method
		accountDAO.addAccount(account, true);
		
		// call the AccountDAO getter/setter methods
		accountDAO.setName("foobar");
		accountDAO.setServiceCode("silver");
		
		String name = accountDAO.getName();
		String serviceCode = accountDAO.getServiceCode();
		
		// call the Membership business method
		memberShipDAO.addAccount();
	}
	
}
