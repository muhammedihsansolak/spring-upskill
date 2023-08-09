package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

    @RequestMapping("/login")
    public String login(){
        return "login.html";
    }

    @RequestMapping("/buy")
    public String buy(){
        return "buy.html";
    }

}
