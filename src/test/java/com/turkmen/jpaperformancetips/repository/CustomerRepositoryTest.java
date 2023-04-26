package com.turkmen.jpaperformancetips.repository;

import com.turkmen.jpaperformancetips.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository repository;

    @Autowired
    private CustomerRepositoryImpl customRepository;


    @Test
    public void testSavePerformance() {
        int numCustomers = 1000;
        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < numCustomers; i++) {
            final Customer customer = new Customer();
            customer.setFirstName("Turkmen" + i);
            customer.setLastName("Demirci" + i);
            customers.add(customer);
        }

        long startTime = System.currentTimeMillis();
        repository.saveAll(customers);
        long endTime = System.currentTimeMillis();
        long saveAllDuration = endTime - startTime;
        System.out.println("SaveAll took " + saveAllDuration + "ms");

        startTime = System.currentTimeMillis();
        for (Customer customer : customers) {
            repository.save(customer);
        }
        endTime = System.currentTimeMillis();
        long saveDuration = endTime - startTime;
        System.out.println("Save took " + saveDuration + "ms");

        startTime = System.currentTimeMillis();
        customRepository.saveCustomers(customers);
        endTime = System.currentTimeMillis();
        long customSaveDuration = endTime - startTime;
        System.out.println("Custom save took " + customSaveDuration + "ms");

        assertTrue(saveDuration > saveAllDuration);
        assertTrue(customSaveDuration < saveAllDuration);
    }
}

