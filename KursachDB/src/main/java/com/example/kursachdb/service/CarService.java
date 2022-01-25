package com.example.kursachdb.service;

import com.example.kursachdb.domain.*;
import com.example.kursachdb.repos.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarService implements ICarService{
    private final BodyTypeRepo bodyTypeRepo;

    private final BrandRepo brandRepo;

    private final CapacityRepo capacityRepo;

    private final CarRepo carRepo;

    private final CountryRepo countryRepo;

    private final EngineRepo engineRepo;

    private final GearBoxRepo gearBoxRepo;

    private final LayoutRepo layoutRepo;

    private final PictureRepo pictureRepo;

    public void deleteCar(Car car) {
        carRepo.delete(car);
    }

    public void findCar(
            Model model,
            Integer makeTypeSelect,
            Integer bodyTypeSelect,
            Integer numSeatsTypeSelect,
            Integer gearBoxTypeSelect
    ) {
        Iterable<Car> cars;

        if (makeTypeSelect == null && bodyTypeSelect == null && numSeatsTypeSelect == null && gearBoxTypeSelect == null)
        {
            cars = carRepo.findAll();
        }
        else
        {
             cars = carRepo.findCarsByBrandIdAndBodyTypeIdAndCapacityIdAndGearBoxId(makeTypeSelect, bodyTypeSelect, numSeatsTypeSelect, gearBoxTypeSelect);
        }

        model.addAttribute("makes", brandRepo.findAll());
        model.addAttribute("bodyTypes", bodyTypeRepo.findAll());
        model.addAttribute("layouts", layoutRepo.findAll());
        model.addAttribute("gearBoxes", gearBoxRepo.findAll());
        model.addAttribute("capacities", capacityRepo.findAll());

        model.addAttribute("cars", cars);
    }

    private void innerAddCar(
            Car car,
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
    ) throws IOException {
        Brand brandFromDB = brandRepo.findBrandByName(brand);
        BodyType bodyTypeFromDB = bodyTypeRepo.findByName_body_type(bodyType);
        Layout layoutFromDB = layoutRepo.findByType_of_drive(layout);
        Capacity capacityFromDB = capacityRepo.findByNumber_of_seats(capacity);
        Engine engineFromDB = engineRepo.findEngineByNameAndHorsePowerAndVolume(engine, engineHP, engineVolume);
        GearBox gearBoxFromDB = gearBoxRepo.findBySwitchingTypeAndNumberOfGears(gearBox, numberOfGears);
        Country countryFromDB = countryRepo.findByName(country);
        Picture pictureFromDB = null;

        if (!imageFile.isEmpty())
        {
            String resultFilename = UUID.randomUUID() + imageFile.getOriginalFilename();
            pictureFromDB = pictureRepo.findPictureByName(resultFilename);

            if (pictureFromDB == null)
            {
                String folder = "src/main/resources/static/images/";
                byte[] bytes = imageFile.getBytes();
                pictureFromDB = new Picture();
                Path path = Paths.get(folder + resultFilename);
                Files.write(path, bytes);
                pictureFromDB.setName(resultFilename);
                pictureRepo.save(pictureFromDB);
            }
        }

        if (brandFromDB == null)
        {
            brandFromDB = new Brand(brand);
            brandRepo.save(brandFromDB);
        }
        if (bodyTypeFromDB == null)
        {
            bodyTypeFromDB = new BodyType(bodyType);
            bodyTypeRepo.save(bodyTypeFromDB);
        }
        if (layoutFromDB == null)
        {
            layoutFromDB = new Layout(layout);
            layoutRepo.save(layoutFromDB);
        }
        if (capacityFromDB == null)
        {
            capacityFromDB = new Capacity(capacity);
            capacityRepo.save(capacityFromDB);
        }
        if (engineFromDB == null)
        {
            engineFromDB = new Engine(engine);
            engineFromDB.setHorsePower(engineHP);
            engineFromDB.setVolume(engineVolume);
            engineRepo.save(engineFromDB);
        }
        if (gearBoxFromDB == null)
        {
            gearBoxFromDB = new GearBox(gearBox);
            gearBoxFromDB.setNumberOfGears(numberOfGears);
            gearBoxRepo.save(gearBoxFromDB);
        }
        if (countryFromDB == null)
        {
            countryFromDB = new Country(country);
            countryRepo.save(countryFromDB);
        }

        if (pictureFromDB == null)
        {
            pictureFromDB = new Picture();
            pictureFromDB.setId(1);
        }

        if (pictureFromDB.getId() == null) {
            pictureFromDB.setId(1);
        }

        if (car.getPicture() == null || car.getPicture().getId() == null)
        {
            car.setPicture(pictureFromDB);
        }

        car.setBrand(brandFromDB);
        car.setBodyType(bodyTypeFromDB);
        car.setLayout(layoutFromDB);
        car.setCapacity(capacityFromDB);
        car.setEngine(engineFromDB);
        car.setGearBox(gearBoxFromDB);
        car.setCountry(countryFromDB);
        car.setModel(carModel);
        car.setPrice(price);
        car.setDescription(description);

        carRepo.save(car);
    }

    @Override
    public void addCar(
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
    ) throws IOException {
        innerAddCar(
                new Car(),
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
    }

    @Override
    public void saveImage(MultipartFile imageFile) throws IOException {
        String folder = "src/main/resources/static/images/";
        byte[] bytes = imageFile.getBytes();
        Path path = Paths.get(folder + imageFile.getOriginalFilename());
        Files.write(path, bytes);
    }

    public void editCar(
            Car car,
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
    ) throws IOException {
        innerAddCar(
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
                price,
                imageFile,
                description
        );
    }
}
