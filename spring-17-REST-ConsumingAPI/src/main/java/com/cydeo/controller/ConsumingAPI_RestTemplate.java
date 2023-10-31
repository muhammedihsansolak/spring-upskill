package com.cydeo.controller;

import com.cydeo.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping("/cydeo")
@RequiredArgsConstructor
public class ConsumingAPI_RestTemplate {

    private final String URI = "https://jsonplaceholder.typicode.com/users";

    private final RestTemplate restTemplate;

    //getForEntity(String url, Class[].class (responseType) )

    @GetMapping
    public ResponseEntity<User[]> readAllUsers(){
        return restTemplate.getForEntity(URI, User[].class);
    }

    //getForObject() -> We can not modify our dto object in this method. getForEntity() is more reasonable

    @GetMapping("{id}")
    public Object readUser(@PathVariable("id")Integer id){
        String URL = URI + "/{id}";
        return restTemplate.getForObject(URL, Object.class, id);
    }

    //exchange() -> Whenever we want to use headers we can use this method


    /*
     Makes an HTTP request to an external API using the Spring RestTemplate. It performs an HTTP GET request to the URL "https://dummyapi.io/data/v1/user?limit=10" with the specified headers and no request body. the purpose of this code is to define a controller method that sends an HTTP GET request to an external API. It sets specific headers for the request, such as the "Accept" header for JSON and a custom "app-id" header.
     */
    @GetMapping("/test")
    public ResponseEntity<Object> consumePostFromDummyApi(){

        HttpHeaders headers =new HttpHeaders();//This line creates an instance of HttpHeaders, which will be used to set HTTP headers for the request that will be sent to an external API
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));//tells the server that the client is expecting JSON data in the response
        headers.set("app-id","6298ebfecd0551211fce37a6");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate.exchange("https://dummyapi.io/data/v1/user?limit=10", HttpMethod.GET,entity,Object.class);
    }


}
