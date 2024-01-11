package com.luv2code.spingboot.cruddemo.rest;

import com.luv2code.spingboot.cruddemo.enity.Employee;
import com.luv2code.spingboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // expose "/employees" return list of employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    // expose "/employees/1" return employee with id = 1
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee employee = employeeService.findEmployeeById(employeeId);

        if (employee == null) {
            throw new RuntimeException("Employee not found id " + employeeId);
        }

        return employee;
    }

    // expose "/employee"
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        // set id = 0 in case of inserting an Employee;
        employee.setId(0);
        return employeeService.save(employee);
    }

    // expose "/employee"
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable int employeeId) {
        Employee employee = employeeService.findEmployeeById(employeeId);

        if (employee == null) {
            throw new RuntimeException("The employee id not found!");
        }

        employeeService.deleteById(employeeId);
    }

}
