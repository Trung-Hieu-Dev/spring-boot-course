package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    // all related advices for logging
    
    /// @BeforeAdvice
    ////@Before("execution(public void addAccount())") // run this code before with any public void addAccount()
    ////@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())") // run this code before only com.luv2code.aopdemo.dao.AccountDAO.addAccount()
    ////@Before("execution(public void add*())") // run this code before with method start with addxxx()
    ////@Before("execution(void add*())") // run this code before with any method start with addxxx() and return type of void
    ////@Before("execution(* add*())") // run this code before with any method start with addxxx() and any return type
    ////@Before("execution(* add*(com.luv2code.aopdemo.Account))") // run this code before with any method start with addxxx() and any return type and parameter with Account type
    ////@Before("execution(* add*(com.luv2code.aopdemo.Account, ..))") // run this code before with any method start with addxxx() and any return type and parameter with Account type, and more parameters
    ////@Before("execution(* addAccount(..))") // run this code before with any addAccount method and any return type and any parameters
    @Before("execution(* com.luv2code.aopdemo.dao.*.*(..))") // run this code before with Match Any Method in a Package
    public void beforeAddAccountAdvice() {
        System.out.println("\n====>>> Executing @Before advice on addAccount()");
    }
    
}
