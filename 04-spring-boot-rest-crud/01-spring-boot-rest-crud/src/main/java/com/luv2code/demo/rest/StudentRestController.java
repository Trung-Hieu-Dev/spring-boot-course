package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> studentList;

    // define @PostConstruct to load the student data ... only once
    @PostConstruct
    public void loadData() {
        // define student list
        studentList = new ArrayList<>();

        // add student
        studentList.add(new Student("Max", "Brown"));
        studentList.add(new Student("Kimmy", "Kenny"));
        studentList.add(new Student("Tommy", "Brown"));
    }

    // endpoint: api/students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentList;
    }

    // endpoint: api/students/1
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        // check the studentId again the size of list
        if (studentId >= studentList.size() || studentId < 0) {
            throw new StudentNotFoundException("The student id not found - " + studentId);
        }

        return studentList.get(studentId);
    }

    /* define service exception handler */
//    // add exception handler
//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
//        // create a StudentErrorResponse
//        StudentErrorResponse error = new StudentErrorResponse();
//
//        error.setStatus(HttpStatus.NOT_FOUND.value());
//        error.setMessage(exc.getMessage());
//        error.setTimeStamp(System.currentTimeMillis());
//
//        // return ResponseEntity
//        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//    }
//
//    // add another exception to catch any errors
//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
//        StudentErrorResponse error = new StudentErrorResponse();
//
//        error.setStatus(HttpStatus.BAD_REQUEST.value());
//        error.setMessage(exc.getMessage());
//        error.setTimeStamp(System.currentTimeMillis());
//
//        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//    }
}
