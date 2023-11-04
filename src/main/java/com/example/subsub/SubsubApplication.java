package com.example.subsub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class SubsubApplication {

    public static void main(String[] args) {
        SpringApplication.run(SubsubApplication.class, args);
    }

}
