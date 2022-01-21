package com.example.kursachdb.service;

import com.example.kursachdb.domain.Customer;
import com.example.kursachdb.domain.Role;
import com.example.kursachdb.repos.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService
{
    private final CustomerRepo customerRepo;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return customerRepo.findByUsername(username);
    }

    public void changeUser(String username, Map<String, String> form, Customer customer) {
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
    }

    public boolean addUser(Customer customer)
    {
        Customer customerFromDb = customerRepo.findByUsername(customer.getUsername());

        if (customerFromDb != null) {
            return false;
        }

        customer.setRoles(Collections.singleton(Role.USER));
        customer.setCustomer_password(passwordEncoder.encode(customer.getPassword()));

        customerRepo.save(customer);

        return true;
    }
}
