package com.example.kursachdb.repos;

import com.example.kursachdb.domain.Engine;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EngineRepo extends CrudRepository<Engine, Integer> {
    @Query("SELECT b FROM Engine b WHERE b.engine_name=?1")
    Engine findByEngine_name(String engine_name);
}
