package com.luv2code.spingboot.cruddemo.service;

import com.luv2code.spingboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.spingboot.cruddemo.enity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements com.luv2code.spingboot.cruddemo.service.EmployeeService {
    private final EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findEmployeeById(Integer theId) {
        return employeeDAO.findEmployeeById(theId);
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return employeeDAO.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(Integer theId) {
        employeeDAO.deleteById(theId);
    }
}
