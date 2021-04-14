package ru.netology.spring_jpa.service;

import org.springframework.stereotype.Service;
import ru.netology.spring_jpa.repository.JpaSpringRepository;

import java.util.List;

@Service
public class JpaSpringService {

    private final JpaSpringRepository jpaSpringRepository;

    public JpaSpringService(JpaSpringRepository jpaSpringRepository) {
        this.jpaSpringRepository = jpaSpringRepository;
    }

    public List getPersonsByCity(String city) {
        return jpaSpringRepository.getPersonsByCity(city);
    }
}
