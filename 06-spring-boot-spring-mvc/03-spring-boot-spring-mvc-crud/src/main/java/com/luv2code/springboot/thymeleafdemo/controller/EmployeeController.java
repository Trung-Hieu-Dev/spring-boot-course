package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
        // get employees from db
        List<Employee> employeeList = employeeService.findAll();

        // add employees to model
        model.addAttribute("employees", employeeList);

        // return view
        return "/employees/list-employees";
    }

    @GetMapping("/showFormAdd")
    public String addEmployee(Model model) {
        // create model attribute to bind data from model
        model.addAttribute("employee", new Employee());

        return "/employees/employeeForm";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        // save employee to db
        employeeService.save(employee);

        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForUpdate")
    public String updateEmployee(@RequestParam("employeeId") int theId, Model model) {
        // get employee from db
        Employee employee = employeeService.findById(theId);

        // add employee to model attribute for data binding
        model.addAttribute("employee", employee);

        return "employees/employeeForm";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int theId) {
        employeeService.deleteById(theId);

        return "redirect:/employees/list";
    }
}
