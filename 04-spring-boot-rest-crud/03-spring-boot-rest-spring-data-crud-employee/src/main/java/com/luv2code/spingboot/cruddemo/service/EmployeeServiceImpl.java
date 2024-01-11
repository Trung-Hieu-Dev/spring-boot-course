package com.luv2code.spingboot.cruddemo.service;

import com.luv2code.spingboot.cruddemo.dao.EmployeeRepository;
import com.luv2code.spingboot.cruddemo.enity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements com.luv2code.spingboot.cruddemo.service.EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findEmployeeById(Integer theId) {
        Optional<Employee> result = employeeRepository.findById(theId);

        Employee theEmployee = null;

        if(result.isPresent()) {
            theEmployee = result.get();
        } else {
            throw new RuntimeException("Employee not found with ID: " + theId);
        }

        return theEmployee;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(Integer theId) {
        employeeRepository.deleteById(theId);
    }
}
