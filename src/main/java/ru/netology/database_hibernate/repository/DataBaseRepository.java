package ru.netology.database_hibernate.repository;

import org.springframework.stereotype.Repository;
import ru.netology.database_hibernate.model.Contact;
import ru.netology.database_hibernate.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Repository
@Transactional
public class DataBaseRepository {


    @PersistenceContext
    private EntityManager entityManager;

    public List getPersonsByCity(String city) {

        fillTableSPersons();

        Query query = entityManager.createQuery("select p from Person p where p.city = :city", Person.class);
        query.setParameter("city", city);
        var resultList = query.getResultList();
        return resultList;

    }


    public void fillTableSPersons() {

        System.out.println("Заполняем базу данных клиентов!");
        var names = List.of("Petr", "Alexey", "Sidor", "Feofan");
        var surnames = List.of("Petrov", "Ivanov", "Smirnov", "Kirillov");
        var cities = List.of("Moscow", "Piter", "Wien", "Berlin");

        var random = new Random();
        IntStream.range(0, 50)
                .forEach(i -> {
                    var person = Person.builder()
                            .name(names.get(random.nextInt(names.size())))
                            .surname(surnames.get(random.nextInt(surnames.size())))
                            .age(random.nextInt(60))
                            .contact(Contact.builder()
                                    .email("name" + i + "surname@gmail.com")
                                    .phone(String.valueOf((random.nextInt(8999999) + 1000000)))
                                    .build())
                            .city(cities.get(random.nextInt(cities.size())))
                            .build();

                    entityManager.persist(person);

                });
    }

}