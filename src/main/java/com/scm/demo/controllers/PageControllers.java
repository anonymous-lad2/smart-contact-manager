package com.scm.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.scm.demo.entities.User;
import com.scm.demo.forms.UserForm;
import com.scm.demo.services.UserService;



@Controller
public class PageControllers {

    @Autowired
    private UserService userService;

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
    public String register(Model model) {

        UserForm userForm = new UserForm();
        model.addAttribute("userForm", userForm);
        return new String("register");
    }

    @RequestMapping(value = "/do-register", method=RequestMethod.POST)
    public String processRegister(@ModelAttribute UserForm userForm){

        // fetch form data
        // System.out.println(userForm);

        // validate form data
        // message = "Registration Successful"

        User user = User.builder()
            .name(userForm.getName())
            .email(userForm.getEmail())
            .password(userForm.getPassword())
            .about(userForm.getAbout())
            .phoneNumber(userForm.getPhoneNumber())
            .profilePic("https://www.shutterstock.com/image-vector/profile-default-avatar-icon-user-600nw-2463844171.jpg")
            .build();

        User savedUser = userService.saveUser(user);
        System.out.println("User saved");
        return "redirect:/register";
    }
    
}
