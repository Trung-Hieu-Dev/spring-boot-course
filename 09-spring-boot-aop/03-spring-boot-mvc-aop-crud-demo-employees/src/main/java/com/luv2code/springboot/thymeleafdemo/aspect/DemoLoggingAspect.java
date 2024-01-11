package com.luv2code.springboot.thymeleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {
    // setup Logger
    private Logger myLogger = Logger.getLogger(getClass().getName());
    
    // setup PointCut Declarations
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
    private void forControllerPackage() {}
    
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
    private void forServicePackage() {}
    
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
    private void forDaoPackage() {}
    
    // combine PointCut
    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {}
    
    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {
        // display method that we are calling
        String theMethod = joinPoint.getSignature().toShortString();
        myLogger.info("====>>> in @Before calling method: " + theMethod);
        
        // display method arguments to the method
        /// get arguments
        Object[] args = joinPoint.getArgs();
        
        /// loop through args and display arg
        for (Object temArg : args) {
            myLogger.info("====>>> argument: " + temArg);
        }
    }
    
    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "theResult")
    public void afterReturning(JoinPoint joinPoint, Object theResult) {
        // display method we are returning from
        String theMethod = joinPoint.getSignature().toShortString();
        myLogger.info("====>>> in @AfterReturning from method: " + theMethod);
        
        // display data returned
        myLogger.info("====>>> the result: " + theResult);
    }
}
