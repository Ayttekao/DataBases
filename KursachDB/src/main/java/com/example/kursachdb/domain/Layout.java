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

    public Layout() {}

    public String getEngine_location() {
        return engine_location;
    }

    public void setEngine_location(String engine_location) {
        this.engine_location = engine_location;
    }

    public String getType_of_drive() {
        return type_of_drive;
    }

    public void setType_of_drive(String type_of_drive) {
        this.type_of_drive = type_of_drive;
    }
}
