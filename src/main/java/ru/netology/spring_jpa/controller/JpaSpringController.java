package ru.netology.spring_jpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.spring_jpa.service.JpaSpringService;

import java.util.List;

@RestController
@RequestMapping("/")
public class JpaSpringController {

    private final JpaSpringService jpaSpringService;

    public JpaSpringController(JpaSpringService jpaSpringService) {
        this.jpaSpringService = jpaSpringService;
    }
    @GetMapping("/persons/by-city")
    public List getPersonsByCity(String city) {
        System.out.println("OK!");
        var resultList = jpaSpringService.getPersonsByCity(city);
        System.out.println("В городе " + city + " живут клиенты:");
//        resultList.forEach(System.out::println);
//        return resultList;
        return null;
    }

}
