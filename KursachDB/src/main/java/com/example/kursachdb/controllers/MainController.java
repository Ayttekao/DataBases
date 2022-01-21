package com.example.kursachdb.controllers;

import com.example.kursachdb.repos.CarRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final CarRepo carRepo;

    @GetMapping("/car-details")
    public String car_details(Model model) {
        return "car-details";
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("cars", carRepo.findAll());
        return "index";
    }
}
