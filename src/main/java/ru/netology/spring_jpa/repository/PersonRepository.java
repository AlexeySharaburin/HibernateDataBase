package ru.netology.spring_jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import ru.netology.spring_jpa.model.IdKey;
import ru.netology.spring_jpa.model.ComposeId;
import ru.netology.spring_jpa.model.Person;

public interface PersonRepository extends JpaRepository<Person, ComposeId> {

}
