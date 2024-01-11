package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
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
	CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);

		//	readStudent(studentDAO);

		//	readAllStudents(studentDAO);

		//	readStudentsByName(studentDAO);

		//	updateStudent(studentDAO);

		//	deleteStudent(studentDAO);

		//	deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		int rowDeleted = studentDAO.deleteAll();
		System.out.println("Row deleted: " + rowDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 2;
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;

		System.out.println("Finding student...");
		Student student = studentDAO.findById(studentId);

		System.out.println("Updating....");
		student.setLast_name("Brown");
		studentDAO.update(student);

		System.out.println("Student Updated!");
		System.out.println(student);
	}

	private void readStudentsByName(StudentDAO studentDAO) {
		String name = "Brown";
		List<Student> studentList = studentDAO.findByLastName(name);

		for (Student student: studentList) {
			System.out.println(student);
		}
	}

	private void readAllStudents(StudentDAO studentDAO) {
		List<Student> studentList = studentDAO.findAll();

		for (Student student: studentList) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		int studentId = 1;
		Student student = studentDAO.findById(studentId);
		System.out.println(student);
	}

	private void createStudent(StudentDAO studentDAO) {
		// create student obj
		System.out.println("Creating student obj...");
		Student student = new Student("Max", "Jimmy", "max@mail.com");

		// save student obj to DB
		System.out.println("Saving student...");
		studentDAO.save(student);

		// display id of saved student
		System.out.println("Student Id: " + student.getId());

	}

}
