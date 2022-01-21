package com.example.kursachdb.repos;

import com.example.kursachdb.domain.BodyType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BodyTypeRepo extends CrudRepository<BodyType, Integer> {
    @Query("SELECT b FROM BodyType b WHERE b.name=?1")
    BodyType findByName_body_type(String name_body_type);
}
