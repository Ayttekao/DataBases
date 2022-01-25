package com.example.kursachdb.repos;

import com.example.kursachdb.domain.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarRepo extends CrudRepository<Car, Integer> {
    @Query("SELECT c FROM Car c WHERE " +
            "(:brandId IS NULL OR c.brand.id = :brandId) AND " +
            "(:bodyTypeId IS NULL OR c.bodyType.id = :bodyTypeId) AND " +
            "(:capacityId IS NULL OR c.capacity.id = :capacityId) AND " +
            "(:gearBoxId IS NULL OR c.gearBox.id = :gearBoxId)")
    List<Car> findCarsByBrandIdAndBodyTypeIdAndCapacityIdAndGearBoxId(
            @Param("brandId") Integer brandId,
            @Param("bodyTypeId") Integer bodyTypeId,
            @Param("capacityId") Integer capacityId,
            @Param("gearBoxId") Integer gearBoxId
    );
}
