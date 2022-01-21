package com.example.kursachdb.controllers;

import com.example.kursachdb.domain.Car;
import com.example.kursachdb.domain.Customer;
import com.example.kursachdb.repos.CarRepo;
import com.example.kursachdb.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    private final CarRepo carRepo;

    @GetMapping
    public String cars(@RequestParam(required=false,name="makeTypeSelect") Integer makeTypeSelect,
                       @RequestParam(required=false,name="bodyTypeSelect") Integer bodyTypeSelect,
                       @RequestParam(required=false,name="numSeatsTypeSelect") Integer numSeatsTypeSelect,
                       @RequestParam(required=false,name="gearBoxTypeSelect") Integer gearBoxTypeSelect,
                     /*@RequestParam Double price,*/
                       Model model) {
        carService.findCar(model, makeTypeSelect, bodyTypeSelect, numSeatsTypeSelect, gearBoxTypeSelect);

        return "cars";
    }

    @GetMapping("{car}")
    public String aboutCar(@PathVariable Car car, Model model) {
        model.addAttribute("car", car);

        return "car-details";
    }

    @GetMapping("/add")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String add(Model model) {
        return "addCar";
    }

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String add(@RequestParam String brand,
                      @RequestParam String car_model,
                      @RequestParam String body_type,
                      @RequestParam String layout,
                      @RequestParam Short capacity,
                      @RequestParam String engine,
                      @RequestParam String gear_box,
                      @RequestParam String county,
                      @RequestParam Double price,
                      Model model) throws IOException {
        carService.addCar(model, brand, car_model, body_type, layout, capacity, engine, gear_box, county, price);
        return "addCar";
    }
}
