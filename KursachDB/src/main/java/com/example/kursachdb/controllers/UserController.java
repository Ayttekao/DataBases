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
public class UserController {
    private final UserService userService;
    private final CustomerRepo customerRepo;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public String userList(Model model) {
        model.addAttribute("users", customerRepo.findAll());

        return "customerList";
    }

    @GetMapping("/profile/{customer}")
    public String userProfile(@PathVariable Customer customer, Model model) {
        model.addAttribute("customer", customer);
        return "customerProfile";
    }

    @GetMapping("{customer}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String userEditForm(@PathVariable Customer customer, Model model) {
        model.addAttribute("roles", Role.values());
        model.addAttribute("customer", customer);

        return "customerEdit";
    }

    @PostMapping("/{customer}/delete")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String delete(@PathVariable Customer customer) {
        userService.deleteUser(customer);
        return "redirect:/user";
    }

    @PostMapping("/profile/{customer}/editEmail")
    public String userChangeEmail(@RequestParam String email, @PathVariable Customer customer) {
        userService.changeEmail(email, customer);
        return "redirect:/user/profile/" + customer.getCustomer_id();
    }

    @PostMapping("/profile/{customer}/editUsername")
    public String userChangeUsername(@RequestParam String username, @PathVariable Customer customer) {
        userService.changeUsername(username, customer);
        return "redirect:/user/profile/" + customer.getCustomer_id();
    }

    @PostMapping("/profile/{customer}/editPassword")
    public String userChangePassword(@RequestParam String up2, @PathVariable Customer customer) {
        userService.changePassword(up2, customer);
        return "redirect:/user/profile/" + customer.getCustomer_id();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public String userSave(
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam("customerId") Customer customer) {
        userService.changeUser(username, form, customer);

        return "redirect:/user";
    }
}