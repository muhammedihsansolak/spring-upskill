package com.cydeo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(WelcomeController.class)
class WelcomeControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void welcomeTest() throws Exception {
        //creating request
        RequestBuilder request = MockMvcRequestBuilders
                .get("/welcome")
                .accept(MediaType.APPLICATION_JSON);

        //sending request
        MvcResult result = mvc.perform(request).andReturn();

        assertEquals(200, result.getResponse().getStatus());
        assertEquals("welcome", result.getResponse().getContentAsString());
    }

    //preferred way to create unit tests for controllers
    @Test
    void welcomeTest2() throws Exception {

        //creating request
        RequestBuilder request = MockMvcRequestBuilders
                .get("/welcome") //HTTP method
                .accept(MediaType.APPLICATION_JSON); //header

        //performing request
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("welcome"))
                .andReturn();
    }

}