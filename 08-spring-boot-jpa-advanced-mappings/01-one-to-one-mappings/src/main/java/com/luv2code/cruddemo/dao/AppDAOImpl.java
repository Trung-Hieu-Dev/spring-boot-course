package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.enity.Instructor;
import com.luv2code.cruddemo.enity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AppDAOImpl implements AppDAO{
    private final EntityManager entityManager;
    
    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }
    
    @Override
    public Instructor findById(Integer theId) {
        return entityManager.find(Instructor.class, theId);
    }
    
    @Override
    public InstructorDetail findInstructorDetailById(Integer theId) {
        return entityManager.find(InstructorDetail.class, theId);
    }
    
    @Override
    @Transactional
    public void deleteInstructorById(Integer theId) {
        Instructor instructor = entityManager.find(Instructor.class, theId);
        
        entityManager.remove(instructor);
    }
    
    @Override
    @Transactional
    public void deleteInstructorDetailById(Integer theId) {
        // find Instructor Detail
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, theId);
        
        // remove associated obj, break bi-directional link
        instructorDetail.getInstructor().setInstructorDetail(null);
        
        // remove Instructor Detail
        entityManager.remove(instructorDetail);
    }
}
