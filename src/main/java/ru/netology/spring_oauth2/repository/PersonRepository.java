package ru.netology.spring_oauth2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.netology.spring_oauth2.model.ComposeId;
import ru.netology.spring_oauth2.model.Person;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, ComposeId> {

    List<Person> findByCity(String city);

    List<Person> findByComposeIdAgeLessThan(int age);

    Optional<Person> findByComposeIdNameAndComposeIdSurname(String name, String surname);

    List<Person> findByComposeIdSurname(String surname);

}
