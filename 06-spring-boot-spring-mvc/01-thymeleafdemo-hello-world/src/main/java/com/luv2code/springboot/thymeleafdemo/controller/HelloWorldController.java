package com.luv2code.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
    /*
    * @RequestMapping: All Http method
    * @GetMapping -> GET Method
    * @PostMapping -> POST method
    * */


//    @RequestMapping("/showForm")
//    public String showForm() {
//        return "helloworld-form";
//    }

    @GetMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    @RequestMapping("processFormVersion2")
    public String letShoutDude(HttpServletRequest servletRequest, Model model) {
        // read the request from html form
        String theName = servletRequest.getParameter("studentName");

        // convert data to uppercase
        theName = theName.toUpperCase();

        // create the message
        String message = "Yo " + theName + "!";

        // add message to Model
        model.addAttribute("message", message);

        return "helloworld";
    }

    @PostMapping ("processFormVersion3")
    public String processFormVersion3(@RequestParam("studentName") String theName, Model model) {

        // convert data to uppercase
        theName = theName.toUpperCase();

        // create the message
        String message = "Yo from V3 " + theName + "!";

        // add message to Model
        model.addAttribute("message", message);

        return "helloworld";
    }
}
