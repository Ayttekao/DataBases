package com.example.kursachdb.controllers;

import com.example.kursachdb.domain.Car;
import com.example.kursachdb.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    @GetMapping
    public String cars(
            @RequestParam(required=false,name="makeTypeSelect") Integer makeTypeSelect,
            @RequestParam(required=false,name="bodyTypeSelect") Integer bodyTypeSelect,
            @RequestParam(required=false,name="numSeatsTypeSelect") Integer numSeatsTypeSelect,
            @RequestParam(required=false,name="gearBoxTypeSelect") Integer gearBoxTypeSelect,
            Model model
    ) {
        carService.findCar(model, makeTypeSelect, bodyTypeSelect, numSeatsTypeSelect, gearBoxTypeSelect);

        return "cars";
    }

    @GetMapping("{car}")
    public String aboutCar(@PathVariable Car car, Model model) {
        model.addAttribute("car", car);

        return "carDetails";
    }

    @GetMapping("/add")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String add() {
        return "addCar";
    }

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String add(
            @RequestParam String brand,
            @RequestParam String carModel,
            @RequestParam String bodyType,
            @RequestParam String layout,
            @RequestParam Short capacity,
            @RequestParam String engine,
            @RequestParam Short engineHP,
            @RequestParam Double engineVolume,
            @RequestParam String gearBox,
            @RequestParam Short numberOfGears,
            @RequestParam String country,
            @RequestParam Double price,
            @RequestParam("imageFile") MultipartFile imageFile,
            @RequestParam String description
    ) throws IOException {
        carService.addCar(
                brand,
                carModel,
                bodyType,
                layout,
                capacity,
                engine,
                engineHP,
                engineVolume,
                gearBox,
                numberOfGears,
                country,
                price,
                imageFile,
                description
        );
        return "addCar";
    }

    @PostMapping("/{car}/delete")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String delete(@PathVariable Car car) {
        carService.deleteCar(car);
        return "redirect:/cars";
    }

    @GetMapping("/{car}/edit")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String edit(@PathVariable Car car, Model model) {
        model.addAttribute("car", car);
        return "editCar";
    }

    @PostMapping("/{car}/edit")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String carEditUpdate(
            @PathVariable Car car,
            @RequestParam String brand,
            @RequestParam String carModel,
            @RequestParam String bodyType,
            @RequestParam String layout,
            @RequestParam Short capacity,
            @RequestParam String engine,
            @RequestParam Short engineHP,
            @RequestParam Double engineVolume,
            @RequestParam String gearBox,
            @RequestParam Short numberOfGears,
            @RequestParam String country,
            @RequestParam("imageFile") MultipartFile imageFile,
            @RequestParam String description
    ) throws IOException {
        carService.editCar(
                car,
                brand,
                carModel,
                bodyType,
                layout,
                capacity,
                engine,
                engineHP,
                engineVolume,
                gearBox,
                numberOfGears,
                country,
                car.getPrice(),
                imageFile,
                description
        );
        return "redirect:/cars";
    }
}
