package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO{
    private String name;
    private String serviceCode;
    
    @Override
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + ": Doing my DB work: Adding an account!");
        System.out.println(account);
        System.out.println();
    }
    
    public String getName() {
        System.out.println(getClass() + " in getName()");
        return name;
    }
    
    public void setName(String name) {
        System.out.println(getClass() + " in setName()");
        this.name = name;
    }
    
    public String getServiceCode() {
        System.out.println(getClass() + " in getService()");
        return serviceCode;
    }
    
    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + " in setService()");
        this.serviceCode = serviceCode;
    }
    
    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }
    
    @Override
    public List<Account> findAccounts(boolean stripWire) {
        if (stripWire) {
            throw new RuntimeException("No soup for you!!!");
        }
        
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("PHP", "Basic"));
        accounts.add(new Account("Java", "Advance"));
        
        return accounts;
    }
}
