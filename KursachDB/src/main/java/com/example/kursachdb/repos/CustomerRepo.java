package com.example.kursachdb.repos;

import com.example.kursachdb.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    Customer findByUsername(String username);
}
