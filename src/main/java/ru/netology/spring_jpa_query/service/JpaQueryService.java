package ru.netology.spring_jpa_query.service;

import org.springframework.stereotype.Service;
import ru.netology.spring_jpa_query.model.One;
import ru.netology.spring_jpa_query.model.Person;
import ru.netology.spring_jpa_query.repository.JpaQueryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JpaQueryService {

    public final JpaQueryRepository jpaQueryRepository;

    public JpaQueryService(JpaQueryRepository jpaQueryRepository) {
        this.jpaQueryRepository = jpaQueryRepository;
    }

    public List getPersonsByCity(String city) {
        return jpaQueryRepository.getPersonsByCity(city);
    }

    public List getPersonsByAge(int age) {
        return jpaQueryRepository.getPersonsByAge(age);
    }

    public Optional<Person> getPersonsByData(One one) {
        return jpaQueryRepository.getPersonsByData(one);
    }


}
