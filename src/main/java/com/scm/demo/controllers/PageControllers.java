package com.scm.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageControllers {

    @RequestMapping("/home")
    public String home(Model model){

        model.addAttribute("name", "Anonymous");
        model.addAttribute("description", "Welcome to the SCM Demo Application");
        model.addAttribute("currentDate", new java.util.Date());
        System.out.println("Home Page Handler");
        return "home";
    }

    @RequestMapping("/about")
    public String about(){
        System.out.println("About Page Handler");
        return "about";
    }

    @RequestMapping("/services")
    public String services(){
        System.out.println("Service Page Handler");
        return "services";
    }

    @GetMapping("/contact")
    public String contact() {
        return new String("contact");
    }

    @GetMapping("/login")
    public String login() {
        return new String("login");
    }
    
    @GetMapping("/register")
    public String register() {
        return new String("register");
    }
    
}
