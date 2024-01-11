package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect // if only have PointCut, @Aspect is optional. Only required if you add advices: @Before, @After...
public class AopExpression {
    /* PointCut Section */
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {} // PointCut Declaration method (named depend on you)
    
    // create a PointCut for the getter methods
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
    public void getter() {}
    
    // create a PointCut for the setter methods
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
    public void setter() {}
    
    
    // combine PointCut for all methods in package exclude the getter/setter methods
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {}
}
