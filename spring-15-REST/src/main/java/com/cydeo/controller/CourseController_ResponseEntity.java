package com.cydeo.controller;

import com.cydeo.dto.CourseDTO;
import com.cydeo.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses/api/v2")
@RequiredArgsConstructor
public class CourseController_ResponseEntity {

    private final CourseService courseService;

    @GetMapping
    public ResponseEntity< List<CourseDTO> > fetchAllCourses() {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("Version","Cydeo.V2.API")
                .header("Operation","Get courses list")
                .body(courseService.getCourses());
    }

    @GetMapping("{id}")
    public ResponseEntity< CourseDTO > fetchCourseById(@PathVariable("id") long id){
        return ResponseEntity
                .ok(courseService.getCourseById(id));
    }

    @GetMapping("category/{categoryName}")
    public ResponseEntity< List<CourseDTO> > fetchByCategory(@PathVariable("categoryName") String categoryName){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(courseService.getCoursesByCategory(categoryName));
    }

    @PostMapping
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO course){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Operation","Course create")
                .body(courseService.createCourse(course));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCourseById(@PathVariable("id") long id){
        courseService.deleteCourseById(id);
        return ResponseEntity
                .noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity updateCourse(@PathVariable("id") long id,@RequestBody CourseDTO course){
        courseService.updateCourse(id,course);
        return ResponseEntity.noContent().build();
    }


}
