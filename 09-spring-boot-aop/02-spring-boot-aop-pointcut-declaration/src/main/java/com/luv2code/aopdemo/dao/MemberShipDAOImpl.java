package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MemberShipDAOImpl implements MemberShipDAO{
    @Override
    public void addAccount() {
        System.out.println(getClass() + ": Doing my DB work: Adding an MemberShip account!");
    }
    
}
