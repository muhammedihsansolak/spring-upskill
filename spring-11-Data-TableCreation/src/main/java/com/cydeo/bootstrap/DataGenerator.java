package com.cydeo.bootstrap;

import com.cydeo.entity.Car;
import com.cydeo.repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {

    private final CarRepository carRepository;

    public DataGenerator(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Car car1 = new Car("BMW","X6");
        Car car2 = new Car("Audi","A4");
        Car car3 = new Car("Mercedes","A180");

        carRepository.save(car1);
        carRepository.save(car2);
        carRepository.save(car3);




    }
}
