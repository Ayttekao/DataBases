package com.example.kursachdb.repos;

import com.example.kursachdb.domain.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CarRepo extends CrudRepository<Car, Integer> {
    @Query("SELECT c FROM Car c JOIN Brand b on c.brand.id = b.id WHERE b.name=?1")
    List<Car> findByBrand(String brand_id);

    @Query("SELECT c FROM Car c WHERE c.bodyType.id=?1")
    List<Car> findTemplates(Integer body_type);

    @Query("SELECT c FROM Car c WHERE c.car_id=?1")
    List<Car> findByCar_id(Integer id);

    List<Car> findByModel(String model);

    @Query("SELECT c FROM Car c JOIN BodyType b on c.bodyType.id = b.id WHERE b.name=?1")
    List<Car> findByBodyType(String body_type);

    @Query("SELECT c FROM Car c JOIN Layout l on c.layout.layout_id = l.layout_id WHERE l.layout_id=?1")
    List<Car> findByLayout(String layout);

    @Query("SELECT c FROM Car c JOIN Capacity b on c.capacity.id = b.id WHERE b.numberOfSeats=?1")
    List<Car> findByCapacity(Short capacity);

    @Query("SELECT c FROM Car c JOIN Engine e on c.engine.id = e.id WHERE e.name=?1")
    List<Car> findByEngine(String engine);

    @Query("SELECT c FROM Car c JOIN GearBox g on c.gearBox.id = g.id WHERE g.switchingType=?1")
    List<Car> findByGearBox(String gear_box);

    @Query("SELECT c FROM Car c JOIN Country g on c.country.id = g.id WHERE g.name=?1")
    List<Car> findByCountry(String country);

    List<Car> findByPrice(Double price);
}
