package com.cydeo.controller;

import com.cydeo.client.EmployeeClient;
import com.cydeo.client.UserClient;
import com.cydeo.dto.ResponseWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ConsumingAPI_FeignClient {

    private final UserClient userClient;
    private final EmployeeClient employeeClient;

    @GetMapping("/users")
    public ResponseEntity<ResponseWrapper> getUsers(){
        return ResponseEntity.ok(new ResponseWrapper("Users fetched!", userClient.getUsers() ));
    }

    @GetMapping("/employee")
    public ResponseEntity<ResponseWrapper> getEmployee(){
        return ResponseEntity.ok(new ResponseWrapper("Employee Retrieved!", employeeClient.getEmployee("6298ebfecd0551211fce37a6") ));
    }


}
