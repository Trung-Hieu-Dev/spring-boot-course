package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.enity.Course;
import com.luv2code.cruddemo.enity.Instructor;
import com.luv2code.cruddemo.enity.InstructorDetail;

import java.util.List;

public interface AppDAO {
    /**
     * One To One
     * */
    // save Instructor
    void save(Instructor instructor);
    
    // find Instructor by id
    Instructor findById(Integer theId);
    
    // find Instructor Detail by id
    InstructorDetail findInstructorDetailById(Integer theId);
    
    // delete Instructor By Id
    void deleteInstructorById(Integer theId);
    
    // delete Instructor Detail By Id
    void deleteInstructorDetailById(Integer theId);
    
    // update Instructor
    void update(Instructor instructor);
    
    /**
     * One to many
     * */
    // == Course section ==//
    
    // find Courses with Instructor ID
    List<Course> findCoursesWithInstructorId(Integer theId);
    
    // get Instructor and Course at once time
    Instructor findInstructorByIdJoinFetch(Integer theId);
    
    // updateCourse
    void update(Course course);
    
    // find Course By Id
    Course findCourseById(Integer theId);
    
    // delete course by id
    void deleteCourseById(Integer theId);
    
}
