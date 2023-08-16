package com.cydeo.controller;

import com.cydeo.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/mentor")  // localhost:8080/mentor
public class MentorController {


    @GetMapping("/register") // localhost:8080/mentor/register
    public String register(Model model){
        List<String> batchList = Arrays.asList("JD1","JD2","JD3");

        model.addAttribute("mentor",new Mentor());
        model.addAttribute("batchList",batchList);

        return "mentor/mentor-register";
    }

    @PostMapping("/confirm")
    public String submitForm(@ModelAttribute("mentor") Mentor mentor, Model model){


     //   return "mentor/mentor-confirmation";
        //return "mentor/mentor-register"; //after registration if we want to see the blank page again, we can set the endpoint like this

        return "redirect:/mentor/register";
    }

}
