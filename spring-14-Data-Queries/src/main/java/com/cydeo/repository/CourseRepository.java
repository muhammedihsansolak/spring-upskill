package com.cydeo.repository;

import com.cydeo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Stream;

public interface CourseRepository extends JpaRepository<Course, Long> {

    //find all courses by input category
    List<Course> findByCategory(String category);
    List<Course> getByCategory(String category);
    List<Course> readByCategory(String category);

    //find all courses by category and order the entities by name
    List<Course> findByCategoryOrderByName(String category);

    //checks if a course with the input exist. If exists return true
    boolean existsByName(String name);

    //return the count based on given category
    Long countByCategory(String category);

    //find all courses that starts with input
    List<Course> findByNameStartingWith(String course);

    //find all courses by category and return stream
    Stream<Course> streamAllByCategory(String category);


}
