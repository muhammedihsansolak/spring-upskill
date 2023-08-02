package com.cydeo.practice.car;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Car {
    String make;
    String model;
    String year;

    public Car(String make, String model, String year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
