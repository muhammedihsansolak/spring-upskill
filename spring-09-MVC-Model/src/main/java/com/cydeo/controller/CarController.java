package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarController {


    // *********************** HTTP REQUEST PARAMETER ***********************

    @RequestMapping("/info") //http://localhost:8080/info?make=Fiat
    public String car(@RequestParam String make, Model model){

        model.addAttribute("model",make);
        System.out.println(make);

        return "car/car-info";
    }

    @RequestMapping("/info3") //http://localhost:8080/info3?make=Nissan&year=2021
    public String car3(@RequestParam String make,@RequestParam int year , Model model){

        model.addAttribute("model",make);
        model.addAttribute("year",year);

        return "car/car-info";
    }

//    @RequestMapping("/info2")
//    public String car2(@RequestParam(value = "make", required = false, defaultValue = "Audi") String make, Model model){
//
//        model.addAttribute("model",make);
//        System.out.println(make);
//
//        return "car/car-info";
//    }


    // *********************** PATH VARIABLE ***********************

    @RequestMapping("/info/{make}") //http://localhost:8080/info/honda
    public String getCarInfo(@PathVariable String make) {

        System.out.println(make);

        return "car/car-info";
    }

}
