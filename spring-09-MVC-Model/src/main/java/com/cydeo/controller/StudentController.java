package com.cydeo.controller;

import com.cydeo.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class StudentController {

    @RequestMapping("/welcome")
    public String homePage(Model model){

        //one way to create an ATTRIBUTE
        model.addAttribute("name","muhammed");
        model.addAttribute("course","MVC");

        //we can define our attribute through variable
        String subject = "Spring Boot";
        model.addAttribute("subject",subject);

        int studentID = new Random().nextInt();
        model.addAttribute("studentID",studentID);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(new Random().nextInt());
        numbers.add(new Random().nextInt());
        numbers.add(new Random().nextInt());
        numbers.add(new Random().nextInt());
        model.addAttribute("numbers",numbers);

        LocalDateTime localDateTime = LocalDateTime.now();
        model.addAttribute("dateTime",localDateTime);

        Student student = new Student(new Random().nextInt(),"Maxwell","Ian");
        model.addAttribute("student",student);

        return "student/welcome";
    }

}
