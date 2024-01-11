package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.enity.Instructor;
import com.luv2code.cruddemo.enity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	
	@Bean
	CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			// System.out.println("Hello World");
			
			// createInstructor(appDAO);
			
			// findInstructor(appDAO);
			
			// deleteInstructor(appDAO);
			
			// findInstructorByInstructorDetail(appDAO);
			
			deleteInstructorDetail(appDAO);
			
		};
	}
	
	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding the Instructor Detail Id: " + theId);
		
		appDAO.deleteInstructorDetailById(theId);
		System.out.println("The Instructor Detail Id " + theId + " was deleted!");
	}
	
	private void findInstructorByInstructorDetail(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding the Instructor Detail Id: " + theId);
		
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(theId);
		
		System.out.println("The Instructor Detail: " + instructorDetail);
		System.out.println("The Instructor: " + instructorDetail.getInstructor());
	}
	
	private void deleteInstructor(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Finding the Instructor Id: " + theId);
		
		appDAO.deleteInstructorById(2);
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
