package com.example.kursachdb.repos;

import com.example.kursachdb.domain.Capacity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CapacityRepo extends CrudRepository<Capacity, Integer> {
    @Query("SELECT b FROM Capacity b WHERE b.numberOfSeats=?1")
    Capacity findByNumber_of_seats(Short number_of_seats);
}
