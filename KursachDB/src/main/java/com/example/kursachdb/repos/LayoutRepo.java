package com.example.kursachdb.repos;

import com.example.kursachdb.domain.Layout;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LayoutRepo extends CrudRepository<Layout, Integer> {
    @Query("SELECT b FROM Layout b WHERE b.type_of_drive=?1")
    Layout findByType_of_drive(String type_of_drive);
}
