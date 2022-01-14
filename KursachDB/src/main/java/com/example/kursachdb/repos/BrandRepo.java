package com.example.kursachdb.repos;

import com.example.kursachdb.domain.Brand;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BrandRepo extends CrudRepository<Brand, Integer> {
    @Query("SELECT b FROM Brand b WHERE b.name_brand=?1")
    Brand findByName_brand(String name_brand);
}
