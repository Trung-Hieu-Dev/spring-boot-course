package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {
    // get country from app properties and create countries list
    @Value("${countries}")
    List<String> countries;

    @Value("${programmingLanguages}")
    List<String> programmingLanguages;

    @Value("${systems}")
    List<String> systems;

    @GetMapping("/showFormStudent")
    public String showForm(Model model) {
        // create a student obj
        Student theStudent = new Student();

        // add student obj to model
        model.addAttribute("student", theStudent);

        // add the list of countries to model
        model.addAttribute("countries", countries);

        // add the list of programming languages to model
        model.addAttribute("programmingLanguages", programmingLanguages);

        // add the list of systems to model
        model.addAttribute("systems", systems);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent) {
        // log the input data
        System.out.println("theStudent: "
                           + theStudent.getFirstName() + " "
                           + theStudent.getLastName() + " "
                           + theStudent.getCountry() + " "
                           + theStudent.getFavouriteSystems());

        return "student-confirmation";
    }
}
