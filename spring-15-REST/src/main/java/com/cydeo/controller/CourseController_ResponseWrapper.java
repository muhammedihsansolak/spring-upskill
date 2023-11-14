package com.cydeo.controller;

import com.cydeo.dto.ResponseWrapper;
import com.cydeo.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/courses/api/v3")
@RequiredArgsConstructor
public class CourseController_ResponseWrapper {

    private final CourseService courseService;

    @GetMapping
    public ResponseEntity< ResponseWrapper > getAllCourses(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseWrapper("Courses Retrieved!",courseService.getCourses()));
    }

//    @GetMapping
//    public ResponseEntity<ResponseWrapper> getAllCourses(){
//
//        return ResponseEntity
//                .status(HttpStatus.ACCEPTED)
//                .header("Version","Cydeo.V3")
//                .body(ResponseWrapper.builder().success(true).message("courses successfully retrieved")
//                        .data(courseService.getCourses()).code(200).build());
////                .body(new ResponseWrapper("courses successfully retrieved",courseService.getCourses()));
//    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseWrapper> getCourseById(@PathVariable("id") long id){
        return ResponseEntity.ok(new ResponseWrapper("Course: " + id + " retrieved", courseService.getCourseById(id)));
    }

}
