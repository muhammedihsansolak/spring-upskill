package com.cydeo.controller;

import com.cydeo.dataGenerator.MentorGenerator;
import com.cydeo.entity.Gender;
import com.cydeo.entity.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MentorController {

    @RequestMapping("/mentor")
    public String mentor(Model model){

        model.addAttribute("mentorList", MentorGenerator.MENTOR_LIST(100));


        return "mentor/mentor";
    }

}
