package com.example.kursachdb.controllers;

import com.example.kursachdb.repos.CarRepo;
import com.example.kursachdb.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final CarRepo carRepo;

    private final CarService carService;

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("cars", carRepo.findAll());
        return "index";
    }

    @PostMapping("/uploadImage")
    public String uploadImage(@RequestParam("imageFile") MultipartFile imageFile, Model model) {
        try {
            carService.saveImage(imageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "addCar";
    }
}
