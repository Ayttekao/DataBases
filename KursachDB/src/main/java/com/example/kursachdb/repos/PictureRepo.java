package com.example.kursachdb.repos;

import com.example.kursachdb.domain.Picture;
import org.springframework.data.repository.CrudRepository;

public interface PictureRepo extends CrudRepository<Picture, Integer> {
    Picture findPictureByName(String name);
}
