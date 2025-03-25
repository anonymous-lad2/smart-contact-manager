package com.scm.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
