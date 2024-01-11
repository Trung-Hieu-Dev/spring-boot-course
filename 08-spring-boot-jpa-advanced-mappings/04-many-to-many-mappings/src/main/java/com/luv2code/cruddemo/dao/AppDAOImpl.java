package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.enity.Course;
import com.luv2code.cruddemo.enity.Instructor;
import com.luv2code.cruddemo.enity.InstructorDetail;
import com.luv2code.cruddemo.enity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        
        List<Course> courseList = instructor.getCourses();
        
        // break associated
        for (Course course: courseList) {
            course.setInstructor(null);
        }
        
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
    
    @Override
    public List<Course> findCoursesWithInstructorId(Integer theId) {
        // create query
        TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id = :data", Course.class);
        query.setParameter("data", theId);
        
        // execute query
        List<Course> courseList = query.getResultList();
        
        return  courseList;
    }
    
    @Override
    public Instructor findInstructorByIdJoinFetch(Integer theId) {
        // create query
        TypedQuery<Instructor> query = entityManager.createQuery("select i from Instructor i "
                                                                 + "join fetch i.courses "
                                                                 + "join fetch i.instructorDetail "
                                                                + "where i.id = :data", Instructor.class);
        query.setParameter("data", theId);
        
        // execute query
        Instructor instructor = query.getSingleResult();
        
        return instructor;
    }
    
    @Override
    @Transactional
    public void update(Instructor instructor) {
        entityManager.merge(instructor);
    }
    
    @Override
    @Transactional
    public void update(Course course) {
        entityManager.merge(course);
    }
    
    @Override
    public Course findCourseById(Integer theId) {
        return entityManager.find(Course.class, theId);
    }
    
    @Override
    @Transactional
    public void deleteCourseById(Integer theId) {
        Course course = entityManager.find(Course.class, theId);
        entityManager.remove(course);
    }
    
    @Override
    @Transactional
    public void save(Course course) {
        entityManager.persist(course);
    }
    
    @Override
    public Course findCourseAndReviewsByCourseId(Integer theId) {
        TypedQuery<Course> query = entityManager.createQuery("select c from Course c " +
                                                             "join fetch c.reviews " +
                                                             "where c.id = :data", Course.class);
        
        query.setParameter("data", theId);
        
        Course course = query.getSingleResult();
        
        return course;
    }
    
    @Override
    public Course findCourseAndStudentByCourseId(Integer theId) {
        TypedQuery<Course> query = entityManager.createQuery("select c from Course c " +
                                                             "join fetch c.students " +
                                                             "where c.id = :data", Course.class);
        
        query.setParameter("data", theId);
        
        Course course = query.getSingleResult();
        
        return course;
    }
    
    @Override
    public Student findStudentAndCoursesByStudentId(Integer theId) {
        TypedQuery<Student> query = entityManager.createQuery("select s from Student s " +
                                                             "join fetch s.courses " +
                                                             "where s.id = :data", Student.class);
        
        query.setParameter("data", theId);
        
        Student student = query.getSingleResult();
        
        return student;
    }
    
    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }
    
    @Override
    @Transactional
    public void deleteStudentById(Integer theId) {
        Student student = entityManager.find(Student.class, theId);
        entityManager.remove(student);
    }
}
