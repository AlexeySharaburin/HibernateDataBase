package ru.netology.spring_jpa.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.netology.spring_jpa.model.Contact;
import ru.netology.spring_jpa.model.ComposeId;
import ru.netology.spring_jpa.model.Person;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Repository
@Transactional
public class JpaSpringRepository {

    @Autowired
    private PersonRepository personRepository;

    public List getPersonsByCity(String city) {
        fillTableSPersons();
        return null;
    }

    public void fillTableSPersons() {

        List<Person> persons = new ArrayList<>();

        System.out.println("Заполняем базу данных клиентов!");
        var names = List.of("Petr", "Alexey", "Sidor", "Feofan");
        var surnames = List.of("Petrov", "Ivanov", "Smirnov", "Kirillov");
        var cities = List.of("Moscow", "Piter", "Wien", "Berlin");

        var random = new Random();
        IntStream.range(0, 10)
                .forEach(i -> {
                    var person = Person.builder()
                            .composeId(ComposeId.builder()
                                    .name(names.get(random.nextInt(names.size())))
                                    .surname(surnames.get(random.nextInt(surnames.size())))
                                    .age(random.nextInt(60))
                                    .build())
                            .contact(Contact.builder()
                                    .email("name" + i + "surname@gmail.com")
                                    .phone(String.valueOf((random.nextInt(8999999) + 1000000)))
                                    .build())
                            .city(cities.get(random.nextInt(cities.size())))
                            .build();

                    persons.add(person);

                });

        personRepository.saveAll(persons);

        persons.forEach(System.out::println);

    }
}
