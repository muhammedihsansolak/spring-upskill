package com.cydeo.practice.config;

import com.cydeo.practice.car.Audi;
import com.cydeo.practice.car.Car;
import com.cydeo.practice.car.Mercedes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarConfig {

    @Bean
    public Car audiCar(){
        return new Audi("A8","2020");
    }

    @Bean
    public Car mercedesCar(){
        return new Mercedes("A180","2021");
    }




}
