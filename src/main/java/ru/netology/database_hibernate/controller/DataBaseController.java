package ru.netology.database_hibernate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.database_hibernate.service.DataBaseService;

import java.util.List;

@RestController
@RequestMapping("/")
public class DataBaseController {

    private final DataBaseService dataBaseService;

    public DataBaseController(DataBaseService dataBaseService) {
        this.dataBaseService = dataBaseService;
    }

    @GetMapping("/persons/by-city")
    public List getPersonsByCity(String city) {
        System.out.println("OK!");
        var resultList = dataBaseService.getPersonsByCity(city);
        System.out.println("В городе " + city + " живут клиенты:");
        resultList.forEach(System.out::println);
        return resultList;
//        return null;
    }
}
