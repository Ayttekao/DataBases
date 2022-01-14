package com.example.kursachdb.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Layout {

    public Layout(String type_of_drive) {
        this.type_of_drive = type_of_drive;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer layout_id;

    private String engine_location;

    private String type_of_drive;

    public Layout() {

    }
}
