package com.luv2code.spingboot.cruddemo.dao;

import com.luv2code.spingboot.cruddemo.enity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
    private final EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
        return theQuery.getResultList();
    }

    @Override
    public Employee findEmployeeById(Integer theId) {
        return entityManager.find(Employee.class, theId);
    }

    @Override
    public Employee save(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public void deleteById(Integer theId) {
        Employee employee = entityManager.find(Employee.class, theId);
        entityManager.remove(employee);
    }
}
