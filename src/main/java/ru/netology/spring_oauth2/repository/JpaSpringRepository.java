package ru.netology.spring_oauth2.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.netology.spring_oauth2.model.ComposeId;
import ru.netology.spring_oauth2.model.Contact;
import ru.netology.spring_oauth2.model.One;
import ru.netology.spring_oauth2.model.Person;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.IntStream;

@Repository
@Transactional
public class JpaSpringRepository {

    @Autowired
    private PersonRepository personRepository;

    @PostConstruct
    public void fillTableSPersons() {

        if (personRepository.findAll().isEmpty()) {
            personRepository.save(new Person(
                    new ComposeId("Anton", "Antonov", 44),
                    new Contact("1111111", "anton.antonov@gmail.com"),
                    "Samara"
            ));

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
                        personRepository.save(person);
                    });
            personRepository.findAll().forEach(System.out::println);
        }
    }

    public List getPersonsByCity(String city) {
        return personRepository.findByCity(city);
    }

    public List getPersonsByAge(int age) {
        return personRepository.findByComposeIdAgeLessThan(age);
    }

    public Optional<Person> getPersonsByData(One one) {
        return personRepository.findByComposeIdNameAndComposeIdSurname(one.getName(), one.getSurname());
    }

    public List getPersonsBySurname(String surname) {
        return personRepository.findByComposeIdSurname(surname);
    }

}
