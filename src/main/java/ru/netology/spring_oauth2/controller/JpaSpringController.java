package ru.netology.spring_oauth2.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.spring_oauth2.model.One;
import ru.netology.spring_oauth2.model.Person;
import ru.netology.spring_oauth2.service.JpaSpringService;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class JpaSpringController {

    private final JpaSpringService jpaSpringService;

    public JpaSpringController(JpaSpringService jpaSpringService) {
        this.jpaSpringService = jpaSpringService;
    }

    @GetMapping("/persons/by-city")
    @Secured("ROLE_READ")
    public List getPersonsByCity(String city) {
        System.out.println("OK!City");
        var resultList = jpaSpringService.getPersonsByCity(city);
        System.out.println("В городе " + city + " живут клиенты:");
        resultList.forEach(System.out::println);
        return resultList;
    }

    @GetMapping("/persons/by-age")
    @PreAuthorize("#username == authentication.principal.username")
    public List getPersonsByAge(int age, String username) {
        System.out.println("OK!Age");
        var resultList = jpaSpringService.getPersonsByAge(age);
        System.out.printf("Уважаемый пользователь %s! Ваш запрос выполнен!\n", username);
        System.out.printf("Клиенты младше %s лет:\n", age);
        resultList.forEach(System.out::println);
        return resultList;
    }

    @GetMapping("/persons/by-data")
    @RolesAllowed("ROLE_WRITE")
    public Optional<Person> getPersonsByData(One one) {
        System.out.println("OK!Data");
        var person = jpaSpringService.getPersonsByData(one);
        System.out.printf("Клиент с именем  %s и фамилией %s:\n", one.getName(), one.getSurname());
        System.out.println(person.toString());
        return person;
    }

    @GetMapping("/persons/by-surname")
    @PostAuthorize(("hasRole('WRITE') or hasRole('DELETE')"))
    public List getPersonsBySurname(String surname) {
        System.out.println("OK!Surname");
        var resultList = jpaSpringService.getPersonsBySurname(surname);
        System.out.printf("Клиенты с фамилией %s:\n", surname);
        resultList.forEach(System.out::println);
        return resultList;
    }




}
