package com.example.kursachdb.controllers;

import com.example.kursachdb.domain.Customer;
import com.example.kursachdb.domain.Role;
import com.example.kursachdb.repos.CustomerRepo;
import com.example.kursachdb.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {
    private final UserService userService;
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
        userService.changeUser(username, form, customer);

        return "redirect:/user";
    }
}