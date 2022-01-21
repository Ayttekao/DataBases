package com.example.kursachdb.repos;

import com.example.kursachdb.domain.Brand;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BrandRepo extends CrudRepository<Brand, Integer> {
    @Query("SELECT b FROM Brand b WHERE b.name=?1")
    Brand findBrandByName(String name_brand);

    Brand findBrandById(Integer id);
}
