package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MemberShipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MemberShipDAO memberShipDAO) {
		return runner -> {
			// @BeforeAdvice
			demoTheBeforeAdvice(accountDAO, memberShipDAO);
		};
	}
	
	private void demoTheBeforeAdvice(AccountDAO accountDAO, MemberShipDAO memberShipDAO) {
		Account account = new Account();
		account.setName("Test");
		account.setLevel("Basic");
		
		// call the business method
		accountDAO.addAccount(account, true);
		
		// call the membership method
		memberShipDAO.addAccount();
	}
	
}
