package com.example.kursachdb.repos;

import com.example.kursachdb.domain.GearBox;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface GearBoxRepo extends CrudRepository<GearBox, Integer> {
    @Query("SELECT b FROM GearBox b WHERE b.switchingType=?1")
    GearBox findBySwitchingType(String engine_name);

    @Query("SELECT g FROM GearBox g WHERE g.switchingType = ?1 AND g.numberOfGears = ?2")
    GearBox findBySwitchingTypeAndNumberOfGears(String switchingType, Short numberOfGears);
}
