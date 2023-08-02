package com.cydeo.practice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@AllArgsConstructor
@Component
public class Car implements AutoDrive{
    private Engine engine;
    private Tier tier;
    private Wheel wheel;

    @Override
    public void autoDrive() {
        System.out.println("Auto driving");
    }
}
