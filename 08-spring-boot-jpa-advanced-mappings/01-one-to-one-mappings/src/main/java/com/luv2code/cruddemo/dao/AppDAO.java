package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.enity.Instructor;
import com.luv2code.cruddemo.enity.InstructorDetail;

public interface AppDAO {
    /**
     * Instructor
     * */
    // save Instructor
    void save(Instructor instructor);
    
    // find Instructor by id
    Instructor findById(Integer theId);
    
    // delete Instructor By Id
    void deleteInstructorById(Integer theId);
    
    /**
     * Instructor Detail
     * */
    // find Instructor Detail by id
    InstructorDetail findInstructorDetailById(Integer theId);
    
    // delete Instructor Detail By Id
    void deleteInstructorDetailById(Integer theId);
    
}
