package com.cydeo.bootstrap;

import com.cydeo.entity.Car;
import com.cydeo.entity.Department;
import com.cydeo.entity.Worker;
import com.cydeo.enums.Gender;
import com.cydeo.repository.CarRepository;
import com.cydeo.repository.DepartmentRepository;
import com.cydeo.repository.WorkerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class DataGenerator implements CommandLineRunner {

    private final CarRepository carRepository;
    private final DepartmentRepository departmentRepository;
    private final WorkerRepository workerRepository;

    public DataGenerator(CarRepository carRepository, DepartmentRepository departmentRepository, WorkerRepository workerRepository) {
        this.carRepository = carRepository;
        this.departmentRepository = departmentRepository;
        this.workerRepository = workerRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Car car1 = new Car("BMW","X6");
        Car car2 = new Car("Audi","A4");
        Car car3 = new Car("Mercedes","A180");

        carRepository.save(car1);
        carRepository.save(car2);
        carRepository.save(car3);

        Department department1 = new Department("HR","abc");

        departmentRepository.save(department1);

        Worker worker1 = new Worker("Muhammed","Solak","M@Cydeo.com", LocalDate.of(2023,12,15), Gender.MALE, BigDecimal.valueOf(45000));

        workerRepository.save(worker1);



    }
}
