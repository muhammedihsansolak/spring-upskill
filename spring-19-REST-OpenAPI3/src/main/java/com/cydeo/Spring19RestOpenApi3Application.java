package com.cydeo;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Spring19RestOpenApi3Application {

    public static void main(String[] args) {
        SpringApplication.run(Spring19RestOpenApi3Application.class, args);
    }

    @Bean
    public ModelMapper mapper() {
        return new ModelMapper();
    }

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(
                        new Info()
                        .title("Cydeo Application OpenAPI")
                        .version("v1")
                        .description("Cydeo API documentation"))
                .servers(
                        List.of(new Server()
                                .url("https://dev.cydeo.com")
                                .description("Dev Environment")));
    }

}
