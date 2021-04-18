package ru.netology.spring_jpa_query.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.netology.spring_jpa_query.model.ComposeId;
import ru.netology.spring_jpa_query.model.Person;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, ComposeId> {

    @Query("select p from Person p where p.city = :city order by p.composeId.name ASC")
    List<Person> findByCity(@Param("city") String city);

    @Query("select p from Person p where p.composeId.age < :age order by p.contact.phone DESC")
    List<Person> findByComposeIdAgeLessThan(@Param("age") int age);

    @Query("select p from Person p where p.composeId.name = :name and p.composeId.surname = :surname order by p.city")
    Optional<Person> findByComposeIdNameAndComposeIdSurname(@Param("name") String name,@Param("surname") String surname);

}
