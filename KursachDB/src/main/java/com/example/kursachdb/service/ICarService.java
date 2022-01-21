package com.example.kursachdb.service;

import com.sun.istack.NotNull;
import org.springframework.ui.Model;

public interface ICarService {
    void addCar(@NotNull Model model,
                String brand,
                String car_model,
                String body_type,
                String layout,
                Short capacity,
                String engine,
                String gear_box,
                String county,
                Double price);
}
