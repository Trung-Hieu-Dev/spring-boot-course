package com.luv2code.spingboot.cruddemo.dao;

import com.luv2code.spingboot.cruddemo.enity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
