package com.luv2code.spingboot.cruddemo.service;

import com.luv2code.spingboot.cruddemo.enity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findEmployeeById(Integer theId);

    Employee save(Employee employee);

    void deleteById(Integer theId);
}
