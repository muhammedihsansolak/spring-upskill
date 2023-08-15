package com.cydeo.dataGenerator;

import com.cydeo.entity.Gender;
import com.cydeo.entity.Mentor;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MentorGenerator {
    public static List<Mentor> MENTOR_LIST(int number){
        List<Mentor> list = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            list.add( new Mentor(
                    Faker.instance().name().firstName(),
                    Faker.instance().name().lastName(),
                    Faker.instance().number().numberBetween(20,43),
                    Gender.values()[Faker.instance().number().numberBetween(0,2)]
            ) );
        }
        return list;
    }
}
