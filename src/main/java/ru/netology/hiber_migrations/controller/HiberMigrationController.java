package ru.netology.hiber_migrations.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hiber_migrations.service.HiberMigrationService;

import java.util.List;

@RestController
@RequestMapping("/")
public class HiberMigrationController {

    private final HiberMigrationService hiberMigrationService;

    public HiberMigrationController(HiberMigrationService hiberMigrationService) {
        this.hiberMigrationService = hiberMigrationService;
    }

    @GetMapping("/persons/by-city")
    public List getPersonByCity(String city) {
        var resultList = hiberMigrationService.getPersonByCity(city);
        System.out.println("В населённом пункте " + city + " проживают:");
        resultList.forEach(System.out::println);
        return resultList;
    }
}
