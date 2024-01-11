package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.enity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	
	@Bean
	CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			// createCourseAnStudents(appDAO);
			
			// findCourseAndStudents(appDAO);
			
			// findStudentAndCourses(appDAO);
			
			// addMoreCourseForStudent(appDAO);
			
			// deleteCourse(appDAO);
			
			deleteStudent(appDAO);
			
		};
	}
	
	/**
	 * Many to many
	 * */
	private void deleteStudent(AppDAO appDAO) {
		int theId = 2;
		appDAO.deleteStudentById(theId);
		System.out.println("Done!");
	}
	
	private void addMoreCourseForStudent(AppDAO appDAO) {
		int theId = 2;
		Student student = appDAO.findStudentAndCoursesByStudentId(theId);
		
		Course course1 = new Course("Java Script Programming");
		Course course2 = new Course("SQL Programming");
		
		student.addCourse(course1);
		student.addCourse(course2);
		
		System.out.println(student);
		System.out.println(student.getCourses());
		
		appDAO.update(student);
		
	}
	
	private void findStudentAndCourses(AppDAO appDAO) {
		int theId = 1;
		
		Student student = appDAO.findStudentAndCoursesByStudentId(theId);
		
		System.out.println(student);
		System.out.println(student.getCourses());
	}
	

	private void findCourseAndStudents(AppDAO appDAO) {
		int theId = 10;
		
		Course course = appDAO.findCourseAndStudentByCourseId(theId);
		
		System.out.println(course);
		System.out.println(course.getStudents());
	}
	
	private void createCourseAnStudents(AppDAO appDAO) {
		// create course
		Course course = new Course("Java Programming");
		
		// create student
		Student student1 = new Student("John", "Brown", "john@mail.com");
		Student student2 = new Student("Mary", "Brown", "mary@mail.com");
		Student student3 = new Student("Susan", "Brown", "susan@mail.com");
		
		
		// add students to course
		course.addStudent(student1);
		course.addStudent(student2);
		course.addStudent(student3);
		
		System.out.println(course);
		System.out.println(course.getStudents());
		
		// save
		appDAO.save(course);
		System.out.println("Done!");
	}
	
	private void deleteCourseAndReviews(AppDAO appDAO) {
		int theId = 1;
		appDAO.deleteCourseById(theId);
		System.out.println("Done!");
	}
	
	private void retrieveCourseAndReviews(AppDAO appDAO) {
		int theId = 1;
		Course course = appDAO.findCourseAndReviewsByCourseId(theId);
		System.out.println(course);
		System.out.println(course.getReviews());
	}
	
	private void createCourseAndReviews(AppDAO appDAO) {
		// create Course
		Course course = new Course("Java Spring Boot A-Z");
		
		// add reviews
		course.add(new Review("Good course"));
		course.add(new Review("Best course"));
		course.add(new Review("Amazing course"));
		
		// save
		System.out.println("Saving Course");
		System.out.println(course);
		System.out.println(course.getReviews());
		
		appDAO.save(course);
	}
	
	private void deleteCourse(AppDAO appDAO) {
		int theId = 10;
		
		// find and delete the course
		System.out.println("Finding the Course Id: " + theId);
		appDAO.deleteCourseById(theId);
		
		System.out.println("Done!");
	}
	
	private void updateCourse(AppDAO appDAO) {
		int theId = 10;
		
		// find the course
		System.out.println("Finding the Course Id: " + theId);
		Course course = appDAO.findCourseById(theId);
		
		// update course
		course.setTitle("Updated Title");
		
		// save
		appDAO.update(course);
		System.out.println("Done!");
	}
	
	private void updateInstructor(AppDAO appDAO) {
		int theId = 1;
		
		// find Instructor
		System.out.println("Finding the Instructor Id: " + theId);
		Instructor instructor = appDAO.findById(theId);
		
		// update Instructor
		System.out.println("Updating the Instructor Id: " + theId);
		instructor.setFirstName("Test Update");
		
		// save Instructor
		appDAO.update(instructor);
		System.out.println("Done!");
	}
	
	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding the Instructor Id: " + theId);
		
		Instructor instructor = appDAO.findInstructorByIdJoinFetch(theId);
		
		System.out.println("The Instructor: \n" + instructor + "\n");
		System.out.println("The Instructor Detail: \n" + instructor.getInstructorDetail() + "\n");
		System.out.println("The Courses: \n" + instructor.getCourses() + "\n");
	}
	
	// Lazy find Courses by Instructor ID
	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding the Instructor Id: " + theId);
		
		Instructor instructor = appDAO.findById(theId);
		
		List<Course> courseList = appDAO.findCoursesWithInstructorId(theId);
		
		// associated oj: set courses
		instructor.setCourses(courseList);
		
		System.out.println("The Courses: " + instructor.getCourses());
		System.out.println("The Instructor: " + instructor);
		
	}
	
	// Eager find Courses by Instructor ID
	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding the Instructor Id: " + theId);
		
		Instructor instructor = appDAO.findById(theId);
		
		System.out.println("The Instructor: " + instructor);
		System.out.println("The Instructor Detail: " + instructor.getInstructorDetail());
		System.out.println("The Courses: " + instructor.getCourses());
		
	}
	
	private void createInstructorWithCourses(AppDAO appDAO) {
		// create Instructor
		Instructor instructor = new Instructor("Susan", "Chery", "susan@mail.com");
		
		// create Instructor Detail
		InstructorDetail instructorDetail = new InstructorDetail("www.youtube.com/susan", "Video Games");
		
		// associated the obj: add Instructor Detail to Instructor
		instructor.setInstructorDetail(instructorDetail);
		
		// associated the obj: add Course to Instructor
		Course php = new Course("PHP Programming");
		Course java = new Course("Java Programming");
		instructor.add(php);
		instructor.add(java);
		
		
		// save to db
		System.out.println("Saving the Instructor: " + instructor);
		System.out.println("Saving the Instructor Detail: " + instructor.getInstructorDetail());
		System.out.println("Saving the Course: " + instructor.getCourses());
		appDAO.save(instructor);
		
		System.out.println("Done!");
	}
	
	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding the Instructor Detail Id: " + theId);
		
		appDAO.deleteInstructorDetailById(theId);
		System.out.println("The Instructor Detail Id " + theId + " was deleted!");
	}
	
	private void findInstructorDetail(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding the Instructor Detail Id: " + theId);
		
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(theId);
		
		System.out.println("The Instructor Detail: " + instructorDetail);
		System.out.println("The Instructor: " + instructorDetail.getInstructor());
	}
	
	private void deleteInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding the Instructor Id: " + theId);
		
		appDAO.deleteInstructorById(theId);
		System.out.println("The Instructor Id " + theId + " was deleted!");
	}
	
	private void findInstructor(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Finding the Instructor Id: " + theId);
		
		Instructor instructor = appDAO.findById(theId);
		
		System.out.println("The Instructor: " + instructor.toString());
		System.out.println("The Instructor Detail: " + instructor.getInstructorDetail());
	}
	
	private void createInstructor(AppDAO appDAO) {
		// create Instructor
		Instructor instructor = new Instructor("Mary", "Cindy", "mary@mail.com");
		
		// create Instructor Detail
		InstructorDetail instructorDetail = new InstructorDetail("www.youtube.com/mary", "reading");
		
		// associated the obj: add Instructor Detail to Instructor
		instructor.setInstructorDetail(instructorDetail);
		
		// save to db
		System.out.println("Saving the Instructor: " + instructor);
		appDAO.save(instructor);
		
		System.out.println("Done!");
	}
	
}
