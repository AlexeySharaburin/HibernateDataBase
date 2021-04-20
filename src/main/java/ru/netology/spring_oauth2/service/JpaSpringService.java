package ru.netology.spring_oauth2.service;

import org.springframework.stereotype.Service;
import ru.netology.spring_oauth2.model.One;
import ru.netology.spring_oauth2.model.Person;
import ru.netology.spring_oauth2.repository.JpaSpringRepository;

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

    public Optional<Person> getPersonsByData(One one) {
        return jpaSpringRepository.getPersonsByData(one);
    }

    public List getPersonsBySurname(String surname) {
        return jpaSpringRepository.getPersonsBySurname(surname);
    }
}
