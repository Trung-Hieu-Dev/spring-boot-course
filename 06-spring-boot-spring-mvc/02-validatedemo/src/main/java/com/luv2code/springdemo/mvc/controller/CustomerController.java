package com.luv2code.springdemo.mvc.controller;

import com.luv2code.springdemo.mvc.model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
    // add @InitBinder to remove white space in all input field.
    // similar to trim()
    // this will be run for every coming requests before the validation code.
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        // check if white space exist, set input field value to null
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        // binding null to input field value in coming requests
        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }


    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @PostMapping("/processForm")
    public String processForm(
            @Valid @ModelAttribute("customer") Customer customer,
            BindingResult bindingResult) {

        // logout to check white space in input field
        System.out.println("Last name: |" + customer.getLastName() + "|");

        // logout the binding results for debugging
        System.out.println("Binding results: " + bindingResult.toString());

        System.out.println("\n\n\n");

        // redirect if errors existed
        if (bindingResult.hasErrors()) {
            return "customer-form";
        } else {
            return "customer-confirmation";
        }
    }
}
