package ru.netology.hibernate_two_tables.service;

import org.springframework.stereotype.Service;
import ru.netology.hibernate_two_tables.repository.HibernateRepository;

import java.util.List;

@Service
public class HibernateService {

    private HibernateRepository hibernateRepository;

    public HibernateService(HibernateRepository hibernateRepository) {
        this.hibernateRepository = hibernateRepository;
    }

    public List getProductName(String name) {
        return hibernateRepository.getProductName(name);
    }
}
