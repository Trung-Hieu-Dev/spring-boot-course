package com.luv2code.spingboot.cruddemo.dao;

import com.luv2code.spingboot.cruddemo.enity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findEmployeeById(Integer theId);

    Employee save(Employee employee);

    void deleteById(Integer theId);
}
