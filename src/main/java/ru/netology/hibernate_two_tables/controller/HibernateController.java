package ru.netology.hibernate_two_tables.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hibernate_two_tables.service.HibernateService;

import java.util.List;

@RestController
@RequestMapping("/")
public class HibernateController {

    private final HibernateService hibernateService;

    public HibernateController(HibernateService hibernateService) {
        this.hibernateService = hibernateService;
    }

    @GetMapping("/products/fetch-product")
    public List getProductName(String name) {
        List productName = hibernateService.getProductName(name);
        System.out.println("Клиент по имени " + name + " купил продукты:");
        productName.forEach(System.out::println);
        return productName;
    }
}
