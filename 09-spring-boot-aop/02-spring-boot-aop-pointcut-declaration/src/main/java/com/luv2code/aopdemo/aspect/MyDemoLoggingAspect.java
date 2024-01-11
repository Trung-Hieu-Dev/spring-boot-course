package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
    @Before("com.luv2code.aopdemo.aspect.AopExpression.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("\n====>>> Executing @Before advice on addAccount()");
        
        // display method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method: " + methodSignature);
        
        // display method args
        /// get args
        Object[] args = theJoinPoint.getArgs();
        
        /// loop through agrs
        for (Object tempArg : args) {
            System.out.println(tempArg);
            
            if (tempArg instanceof Account) {
                Account account = (Account) tempArg;
                System.out.println("account name: " + account.getName());
                System.out.println("account level: " + account.getLevel());
            }
        }
    }
    
    @AfterReturning(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n====>>> Executing @AfterReturning on method: " + method);
        
        // print out the result
        System.out.println("\n====>>> result is: " + result);
        
        // post-process data (modify data) before return to client
        convertAccountNameToUpperCase(result);
        System.out.println("\n====>>> uppercase result is: " + result);
        
    }
    
    private void convertAccountNameToUpperCase(List<Account> result) {
        for (Account account : result) {
            String upperCaseName = account.getName().toUpperCase();
            account.setName(upperCaseName);
        }
    }
    
    @AfterThrowing(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable theExc) {
        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n====>>> Executing @AfterThrowing on method: " + method);
        
        // print out the exception
        System.out.println("\n====>>> exception is: " + theExc);
    }
    
    @After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n====>>> Executing @After (finally) on method: " + method);
    }
    
    @Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint joinPoint) throws Throwable {
        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n====>>> Executing @Around on method: " + method);
        
        // get begin timestamp
        long begin = System.currentTimeMillis();
        
        // execute method
        Object result = null;
        
        try {
            result = joinPoint.proceed();
        }
        catch (Exception exc) {
            // log the exception
            System.out.println(exc.getMessage());
            
            // give client a custom message
//             result = "Custom Error message for client!";
            
            // rethrown exc
            throw exc;
        }
        
        
        // get en timestamp
        long end = System.currentTimeMillis();
        
        // compute duration and display it
        long duration = end - begin;
        System.out.println("\n====>>> Duration: " + duration / 1000 + " seconds");
        
        return result;
    }
}
