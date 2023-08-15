package com.cydeo.bootstrap;

import com.cydeo.model.Student;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataGenerator {

    public static List<Student> createStudent(){
        List<Student> students = Arrays.asList(
                new Student(Faker.instance().name().firstName(),
                        Faker.instance().name().lastName(),
                        Faker.instance().number().numberBetween(18,52),
                        Faker.instance().address().state()),
                new Student(Faker.instance().name().firstName(),
                        Faker.instance().name().lastName(),
                        Faker.instance().number().numberBetween(18,52),
                        Faker.instance().address().state()),
                new Student(Faker.instance().name().firstName(),
                        Faker.instance().name().lastName(),
                        Faker.instance().number().numberBetween(18,52),
                        Faker.instance().address().state())

        );
        return students;
    }
}
