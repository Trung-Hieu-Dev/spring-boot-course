package com.luv2code.springboot.thymeleafdemo.dao;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it ... no need to write any code LOL!

    // add sort by last name
    /*
    * Note
    * findAllByOrderByLastNameAsc behind the spring data jpa automatically create by syntax
    * pattern: findAllBy (given by spring data jpa - select all)
    * SQL Syntax: OrderByLastNameAsc
    * doc: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.details
    * */
    public List<Employee> findAllByOrderByLastNameAsc();

}
