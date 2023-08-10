package com.cydeo.controller;

import com.cydeo.entity.Gender;
import com.cydeo.entity.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MentorController {

    @RequestMapping("/mentor")
    public String mentor(Model model){

        model.addAttribute("mentor1",new Mentor("Maxwell","Ian",24, Gender.MALE));
        model.addAttribute("mentor2",new Mentor("Cundullah","T",32, Gender.MALE));
        model.addAttribute("mentor3",new Mentor("Yuliya","Yıgıt",26, Gender.FEMALE));


        return "mentor/mentor.html";
    }

}
