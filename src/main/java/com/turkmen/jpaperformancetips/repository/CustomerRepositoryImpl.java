package com.turkmen.jpaperformancetips.repository;

import com.turkmen.jpaperformancetips.model.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class CustomerRepositoryImpl {
    @PersistenceContext
    private EntityManager entityManager;

    public void saveCustomers(List<Customer> customers) {
        int batchSize = 20;
        for (int i = 0; i < customers.size(); i += batchSize) {
            List<Customer> batch = customers.subList(i, Math.min(i + batchSize, customers.size()));
            for (Customer customer : batch) {
                entityManager.merge(customer);
            }
            entityManager.flush();
            entityManager.clear();
        }
    }
}
