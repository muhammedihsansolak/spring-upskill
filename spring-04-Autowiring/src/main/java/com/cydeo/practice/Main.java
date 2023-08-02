package com.cydeo.practice;

import com.cydeo.practice.config.CarConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(CarConfig.class);

        Car myCar = context.getBean(Car.class);

        myCar.autoDrive();

    }
}
