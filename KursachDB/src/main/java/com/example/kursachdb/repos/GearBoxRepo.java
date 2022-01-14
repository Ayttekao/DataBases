package com.example.kursachdb.repos;

import com.example.kursachdb.domain.GearBox;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GearBoxRepo extends CrudRepository<GearBox, Integer> {
    @Query("SELECT b FROM GearBox b WHERE b.switching_type=?1")
    GearBox findBySwitching_type(String engine_name);
}
