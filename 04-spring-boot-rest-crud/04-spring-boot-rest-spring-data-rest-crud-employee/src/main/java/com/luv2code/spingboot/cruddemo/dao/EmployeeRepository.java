package com.luv2code.spingboot.cruddemo.dao;

import com.luv2code.spingboot.cruddemo.enity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryRestResource(path = "members") // endpoint localhost:3306/api/members instead of localhost:3306/api/employees
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
