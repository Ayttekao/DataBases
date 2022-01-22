package com.example.kursachdb.repos;

import com.example.kursachdb.domain.Engine;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EngineRepo extends CrudRepository<Engine, Integer> {
    @Query("SELECT b FROM Engine b WHERE b.name=?1")
    Engine findEngineByName(String engineName);

    @Query("SELECT e FROM Engine e WHERE " +
            "(:name IS NULL OR e.name = :name) AND " +
            "(:horsePower IS NULL OR e.horsePower = :horsePower) AND " +
            "(:volume IS NULL OR e.volume - :volume < 0.1)")
    Engine findEngineByNameAndHorsePowerAndVolume(
            @Param("name") String name,
            @Param("horsePower") Short horsePower,
            @Param("volume") Double volume);
}
