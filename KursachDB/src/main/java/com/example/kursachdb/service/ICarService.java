package com.example.kursachdb.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ICarService {
    void addCar(
            String brand,
            String carModel,
            String bodyType,
            String layout,
            Short capacity,
            String engine,
            Short engineHP,
            Double engineVolume,
            String gearBox,
            Short numberOfGears,
            String country,
            Double price,
            MultipartFile imageFile,
            String description
    ) throws IOException;

    void saveImage(MultipartFile imageFile) throws IOException;
}
