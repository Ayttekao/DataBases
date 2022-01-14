package com.example.kursachdb.controllers;

import com.example.kursachdb.domain.Customer;
import com.example.kursachdb.domain.Role;
import com.example.kursachdb.repos.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {

    private final CustomerRepo customerRepo;

    @GetMapping
    public String userList(Model model) {
        model.addAttribute("users", customerRepo.findAll());

        return "customerList";
    }

    @GetMapping("{customer}")
    public String userEditForm(@PathVariable Customer customer, Model model) {
        model.addAttribute("roles", Role.values());
        model.addAttribute("customer", customer);

        return "customerEdit";
    }

    @PostMapping
    public String userSave(
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam("customerId") Customer customer) {
        customer.setUsername(username);

        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        customer.getRoles().clear();

        for(String key : form.keySet())
        {
            if(roles.contains(key))
            {
                customer.getRoles().add(Role.valueOf(key));
            }
        }
        customerRepo.save(customer);
        return "redirect:/user";
    }
}