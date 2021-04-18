package ru.netology.hiber_migrations.repository;

import org.springframework.stereotype.Repository;
import ru.netology.hiber_migrations.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class HiberMigrationRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List getPersonByCity(String city) {
        Query query = entityManager.createQuery("select p from Person p where p.cityOfLiving = :city", Person.class);
        query.setParameter("city", city);
        var resultList = query.getResultList();
        return resultList;
    }
}
