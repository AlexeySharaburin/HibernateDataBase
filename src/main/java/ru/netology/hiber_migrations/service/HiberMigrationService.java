package ru.netology.hiber_migrations.service;

import org.springframework.stereotype.Service;
import ru.netology.hiber_migrations.repository.HiberMigrationRepository;

import java.util.List;

@Service
public class HiberMigrationService {

    private final HiberMigrationRepository hiberMigrationRepository;

    public HiberMigrationService(HiberMigrationRepository hiberMigrationRepository) {
        this.hiberMigrationRepository = hiberMigrationRepository;
    }

    public List getPersonByCity(String city) {
        return hiberMigrationRepository.getPersonByCity(city);
    }
}
