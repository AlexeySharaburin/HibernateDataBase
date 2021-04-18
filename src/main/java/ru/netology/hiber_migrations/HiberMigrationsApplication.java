package ru.netology.hiber_migrations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HiberMigrationsApplication {

    public static void main(String[] args) {
        SpringApplication.run(HiberMigrationsApplication.class, args);
        System.out.println("Welcome!");
    }

}
