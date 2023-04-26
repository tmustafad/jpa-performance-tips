package com.turkmen.jpaperformancetips.repository;

import com.turkmen.jpaperformancetips.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
