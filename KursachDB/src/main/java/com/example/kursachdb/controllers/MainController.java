package com.example.kursachdb.controllers;

import com.example.kursachdb.domain.*;
import com.example.kursachdb.repos.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.Objects;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final BodyTypeRepo bodyTypeRepo;

    private final BrandRepo brandRepo;

    private final CapacityRepo capacityRepo;

    private final CarRepo carRepo;

    private final CountryRepo countryRepo;

    private final EngineRepo engineRepo;

    private final GearBoxRepo gearBoxRepo;

    private final LayoutRepo layoutRepo;

    @GetMapping("/car-details")
    public String car_details(Model model) {
        return "car-details";
    }

    @GetMapping("/cars")
    public String cars(@RequestParam(required=false,name="makeTypeSelect") String makeTypeSelect,
                       @RequestParam(required=false,name="bodyTypeSelect") String bodyTypeSelect,
                       @RequestParam(required=false,name="numSeatsTypeSelect") String numSeatsTypeSelect,
                       @RequestParam(required=false,name="gearBoxTypeSelect") String gearBoxTypeSelect,
                       /*@RequestParam Double price,*/
                       Model model) {
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

        return "cars";
    }

    @GetMapping("/index")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/add")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String add(Model model) {
        Iterable<Car> cars = carRepo.findAll();
        model.addAttribute("cars", cars);
        return "add";
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

        Brand brandFromDB = brandRepo.findByName_brand(brand);
        BodyType bodyTypeFromDB = bodyTypeRepo.findByName_body_type(body_type);
        Layout layoutFromDB = layoutRepo.findByType_of_drive(layout);
        Capacity capacityFromDB = capacityRepo.findByNumber_of_seats(capacity);
        Engine engineFromDB = engineRepo.findByEngine_name(engine);
        GearBox gearBoxFromDB = gearBoxRepo.findBySwitching_type(gear_box);
        Country countryFromDB = countryRepo.findByName(county);

        if (brandFromDB == null)
        {
            brandFromDB = new Brand(brand);
            brandRepo.save(brandFromDB);
        }
        if (bodyTypeFromDB == null)
        {
            bodyTypeFromDB = new BodyType(body_type);
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
            gearBoxFromDB = new GearBox(gear_box);
            gearBoxRepo.save(gearBoxFromDB);
        }
        if (countryFromDB == null)
        {
            countryFromDB = new Country(county);
            countryRepo.save(countryFromDB);
        }

        Car car = new Car();
        car.setBrand(brandFromDB);
        car.setModel(car_model);
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

        return "add";
    }
}
