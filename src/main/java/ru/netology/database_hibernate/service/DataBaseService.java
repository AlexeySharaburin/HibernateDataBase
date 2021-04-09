package ru.netology.database_hibernate.service;

import org.springframework.stereotype.Service;
import ru.netology.database_hibernate.repository.DataBaseRepository;

import java.util.List;

@Service
public class DataBaseService {

    private DataBaseRepository dataBaseRepository;

    public DataBaseService(DataBaseRepository dataBaseRepository) {
        this.dataBaseRepository = dataBaseRepository;
    }

    public List getPersonsByCity(String city) {
        return dataBaseRepository.getPersonsByCity(city);
    }
}
