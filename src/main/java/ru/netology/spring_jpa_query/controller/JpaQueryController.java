package ru.netology.spring_jpa_query.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.spring_jpa_query.model.One;
import ru.netology.spring_jpa_query.model.Person;
import ru.netology.spring_jpa_query.service.JpaQueryService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class JpaQueryController {
    private final JpaQueryService jpaQueryService;

    public JpaQueryController(JpaQueryService jpaQueryService) {
        this.jpaQueryService = jpaQueryService;
    }

    @GetMapping("/persons/by-city")
    public List getPersonsByCity(String city) {
        System.out.println("OK!City");
        var resultList = jpaQueryService.getPersonsByCity(city);
        System.out.println("В городе " + city + " живут клиенты:");
        resultList.forEach(System.out::println);
        return resultList;
    }

    @GetMapping("/persons/by-age")
    public List getPersonsByAge(int age) {
        System.out.println("OK!Age");
        var resultList = jpaQueryService.getPersonsByAge(age);
        System.out.printf("Клиенты младше %s лет:\n", age);
        resultList.forEach(System.out::println);
        return resultList;
    }

    @GetMapping("/persons/by-data")
    public Optional<Person> getPersonsByData(One one) {
        System.out.println("OK!Data");
        var person = jpaQueryService.getPersonsByData(one);
        System.out.printf("Клиент с именем  %s и фамилией %s:\n", one.getName(), one.getSurname());
        System.out.println(person.toString());
        return person;
    }

}
