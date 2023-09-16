package com.cydeo;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.output.MigrateResult;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class CinemaLabOrmApp {

    public static void main(String[] args) {
        SpringApplication.run(CinemaLabOrmApp.class, args);
    }

    /**
     * this method sets up and runs Flyway database migrations based on the provided DataSource. It ensures that the database schema is kept up-to-date with the application's requirements and includes a baseline step if needed. The MigrateResult object can be used elsewhere in the application to log or report the migration results if necessary.
     */
    @Bean
    public MigrateResult migrateResult(DataSource dataSource){
        return Flyway.configure().baselineOnMigrate(true).dataSource(dataSource).load().migrate();
    }


}
