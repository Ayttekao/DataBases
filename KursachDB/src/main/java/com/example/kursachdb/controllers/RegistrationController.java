package com.example.kursachdb.controllers;

import com.example.kursachdb.domain.Customer;
import com.example.kursachdb.domain.Role;
import com.example.kursachdb.repos.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class RegistrationController {

    private final CustomerRepo customerRepo;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(Customer customer, Map<String, Object> model) {
        Customer customerFromDb = customerRepo.findByUsername(customer.getUsername());

        if (customerFromDb != null) {
            model.put("message", "User exists!");
            return "registration";
        }

        customer.setRoles(Collections.singleton(Role.USER));

        customerRepo.save(customer);

        return "redirect:/login";
    }
}