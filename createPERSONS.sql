create SCHEMA netology;

CREATE TABLE PERSONS
(
    name VARCHAR(20) NOT NULL,
    surname VARCHAR(20) NOT NULL,
    age integer CHECK (age> 0),
    phone_number VARCHAR(20) NOT NULL,
    city_of_living VARCHAR(20) NOT NULL,
    PRIMARY KEY (name, surname, age)
);

insert into PERSONS (name, surname, age, phone_number, city_of_living)
values ('Ivan', 'Ivanov', 29, '1234567', 'MOSCOW');
insert into PERSONS (name, surname, age, phone_number, city_of_living)
values ('Petr', 'Petrov', 31, '2234567', 'PITER');
insert into PERSONS (name, surname, age, phone_number, city_of_living)
values ('Sidor', 'Sidorov', 19, '3234567', 'MOSCOW');
insert into PERSONS (name, surname, age, phone_number, city_of_living)
values ('Ivan', 'Sidorov', 44, '5234567', 'MOSCOW');
