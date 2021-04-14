package ru.netology.spring_jpa.service;

import org.springframework.stereotype.Service;
import ru.netology.spring_jpa.model.Person;
import ru.netology.spring_jpa.repository.JpaSpringRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JpaSpringService {

    private final JpaSpringRepository jpaSpringRepository;

    public JpaSpringService(JpaSpringRepository jpaSpringRepository) {
        this.jpaSpringRepository = jpaSpringRepository;
    }

    public List getPersonsByCity(String city) {
        return jpaSpringRepository.getPersonsByCity(city);
    }

    public List getPersonsByAge(int age) {
        return jpaSpringRepository.getPersonsByAge(age);
    }

    public Optional<Person> getPersonsByData(String name, String surname) {
        return jpaSpringRepository.getPersonsByData(name, surname);
    }
}
