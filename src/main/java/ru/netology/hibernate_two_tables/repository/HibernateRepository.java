package ru.netology.hibernate_two_tables.repository;

import org.springframework.stereotype.Repository;
import ru.netology.hibernate_two_tables.model.Customer;
import ru.netology.hibernate_two_tables.model.Order;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Transactional
@Repository
public class HibernateRepository {

    @PersistenceContext
    private EntityManager entityManager;

    List<Customer> customersList = new ArrayList<>();

    public List getProductName(String name) {

        fillCustomers();
        fillOrders();

        Query query = entityManager.createQuery("select od.productName from Order od join Customer cu on cu.id = od.customer.id where cu.name = :name", String.class);
        query.setParameter("name", name);
        var result = query.getResultList();
        System.out.println(result.toString());

        return result;
    }

    public void fillCustomers() {

        System.out.println("Заполняем базу данных клиентов!");
        var names = List.of("Petr", "Alexey", "Sidor", "Feofan");
        var surnames = List.of("Petrov", "Ivanov", "Smirnov", "Kirillov");

        var random = new Random();
        IntStream.range(0, 10)
                .forEach(i -> {
                    var customer = Customer.builder()
                            .name(names.get(random.nextInt(names.size())))
                            .surname(surnames.get(random.nextInt(surnames.size())))
                            .age(random.nextInt(60) + 1)
                            .phone(String.valueOf((random.nextInt(8999999) + 1000000)))
                            .build();

                    customersList.add(customer);

                    entityManager.persist(customer);

                });
    }

    public void fillOrders() {

        System.out.println("Заполняем базу заказов!");
        var productNames = List.of("Brot", "Milch", "Water", "Tomat", "Potato", "Butter", "Wegetablbles");

        String time = new SimpleDateFormat("HH:mm:ss dd.MM.yyyy").format(new Date());
        var random = new Random();
        IntStream.range(0, 10)
                .forEach(i -> {
                    var order = Order.builder()
                            .date(time)
                            .customer(customersList.remove(0))
                            .productName(productNames.get(random.nextInt(productNames.size())))
                            .amount(random.nextInt(20) + 1)
                            .build();

                    entityManager.persist(order);

                });
    }
}
