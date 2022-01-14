package com.example.kursachdb.repos;

import com.example.kursachdb.domain.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CountryRepo extends CrudRepository<Country, Integer> {
    @Query("SELECT b FROM Country b WHERE b.name=?1")
    Country findByName(String name);
}
