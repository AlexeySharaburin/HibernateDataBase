package ru.netology.spring_jpa_security.service;

import org.springframework.stereotype.Service;
import ru.netology.spring_jpa_security.model.One;
import ru.netology.spring_jpa_security.model.Person;
import ru.netology.spring_jpa_security.repository.JpaSpringRepository;

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
}
