package com.cydeo.repository;

import com.cydeo.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//normally we put @Component annotations class level but we put @Component to interface since in execution time spring creates implementation classes. In new versions of spring, we even do not put @Repository. We can omit it.
//@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
}
