package com.example.kursachdb.service;

import com.example.kursachdb.domain.*;
import com.example.kursachdb.repos.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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

    public void findCar(
            Model model,
            String makeTypeSelect,
            String bodyTypeSelect,
            String numSeatsTypeSelect,
            String gearBoxTypeSelect
    ) {
        Iterable<Car> cars = carRepo.findAll();

        Iterable<Brand> makes = brandRepo.findAll();
        Iterable<BodyType> bodyTypes = bodyTypeRepo.findAll();
        Iterable<Layout> layouts = layoutRepo.findAll();
        Iterable<GearBox> gearBoxes = gearBoxRepo.findAll();
        Iterable<Capacity> capacities = capacityRepo.findAll();
        model.addAttribute("makes", makes);
        model.addAttribute("bodyTypes", bodyTypes);
        model.addAttribute("layouts", layouts);
        model.addAttribute("gearBoxes", gearBoxes);
        model.addAttribute("capacities", capacities);

        if (!Objects.equals(makeTypeSelect, "All"))
        {
            cars = carRepo.findByBrand(makeTypeSelect);
        }
        if (!Objects.equals(bodyTypeSelect, "All"))
        {
            cars = carRepo.findByBodyType(bodyTypeSelect);
        }
        if (!Objects.equals(numSeatsTypeSelect, "All"))
        {
            try {
                cars = carRepo.findByCapacity(Short.parseShort(numSeatsTypeSelect));
            } catch (NumberFormatException ignored) {}
        }
        if (!Objects.equals(gearBoxTypeSelect, "All"))
        {
            cars = carRepo.findByGearBox(gearBoxTypeSelect);
        }

        model.addAttribute("cars", cars);
    }


    @Override
    public void addCar(
            Model model,
            String brand,
            String carModel,
            String bodyType,
            String layout,
            Short capacity,
            String engine,
            String gearBox,
            String county,
            Double price
    ) {
        Brand brandFromDB = brandRepo.findBrandByName(brand);
        BodyType bodyTypeFromDB = bodyTypeRepo.findByName_body_type(bodyType);
        Layout layoutFromDB = layoutRepo.findByType_of_drive(layout);
        Capacity capacityFromDB = capacityRepo.findByNumber_of_seats(capacity);
        Engine engineFromDB = engineRepo.findEngineByName(engine);
        GearBox gearBoxFromDB = gearBoxRepo.findBySwitchingType(gearBox);
        Country countryFromDB = countryRepo.findByName(county);

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
            engineRepo.save(engineFromDB);
        }
        if (gearBoxFromDB == null)
        {
            gearBoxFromDB = new GearBox(gearBox);
            gearBoxRepo.save(gearBoxFromDB);
        }
        if (countryFromDB == null)
        {
            countryFromDB = new Country(county);
            countryRepo.save(countryFromDB);
        }

        Car car = new Car();
        car.setBrand(brandFromDB);
        car.setModel(carModel);
        car.setBodyType(bodyTypeFromDB);
        car.setLayout(layoutFromDB);
        car.setCapacity(capacityFromDB);
        car.setEngine(engineFromDB);
        car.setGearBox(gearBoxFromDB);
        car.setCountry(countryFromDB);
        car.setPrice(price);

        carRepo.save(car);

        Iterable<Car> cars = carRepo.findAll();
        model.addAttribute("cars", cars);
    }
}
