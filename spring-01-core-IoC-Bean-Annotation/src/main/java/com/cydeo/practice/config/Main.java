package com.cydeo.practice.config;

import com.cydeo.practice.car.Audi;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(CarConfig.class);

        //container.getBean(Car.class); //.NoUniqueBeanDefinitionException

        System.out.println( container.getBean(Audi.class) );


    }
}
