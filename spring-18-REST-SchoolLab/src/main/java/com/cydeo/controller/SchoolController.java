package com.cydeo.controller;

import com.cydeo.dto.AddressDTO;
import com.cydeo.dto.CourseDTO;
import com.cydeo.dto.response.ResponseWrapper;
import com.cydeo.dto.TeacherDTO;
import com.cydeo.service.AddressService;
import com.cydeo.service.ParentService;
import com.cydeo.service.StudentService;
import com.cydeo.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SchoolController {

    private final TeacherService teacherService;
    private final StudentService studentService;
    private final ParentService parentService;
    private final AddressService addressService;

    @GetMapping("/teachers")
    public List<TeacherDTO> getAllTeachers(){
        List<TeacherDTO> dtoList = teacherService.findAll();
        return dtoList;
    }

    @GetMapping("/students")
    public ResponseEntity<ResponseWrapper> fetchAllStudents(){
        return ResponseEntity.ok(
                new ResponseWrapper("Students are retrieved!",
                studentService.findAll()
        ));
    }

    @GetMapping("/parents")
    public ResponseEntity<ResponseWrapper> getAllParents(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        new ResponseWrapper(
                                true,
                                "Parents successfully fetched!",
                                HttpStatus.OK.value(),
                                parentService.findAll()
                        )
                );
    }

    @GetMapping("/address/{id}")
    public ResponseEntity< ResponseWrapper > getAddressById(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok(
                new ResponseWrapper(
                        "Address found Successfully!",
                        addressService.findById(id))
        );
    }

    @PutMapping("/address/{id}")
    public AddressDTO updateAddress(@PathVariable("id")Long id, @RequestBody AddressDTO addressDTO) throws Exception {
        addressDTO.setId(id);
        return addressService.update(addressDTO);
    }

}
