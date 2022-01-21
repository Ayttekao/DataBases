package com.example.kursachdb.repos;

import com.example.kursachdb.domain.Engine;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface EngineRepo extends CrudRepository<Engine, Integer> {
    @Query("SELECT b FROM Engine b WHERE b.name=?1")
    Engine findEngineByName(String engine_name);
}
