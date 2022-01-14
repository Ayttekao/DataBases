package com.example.kursachdb.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Engine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer engine_id;

    private String engine_name;

    private Double capacity;

    public Engine(String engine_name) {
        this.engine_name = engine_name;
    }

    private Short horse_power;

    public Engine() {

    }

    public Integer getEngine_id() {
        return engine_id;
    }

    public void setEngine_id(Integer engine_id) {
        this.engine_id = engine_id;
    }

    public String getEngine_name() {
        return engine_name;
    }

    public void setEngine_name(String engine_name) {
        this.engine_name = engine_name;
    }

    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    public Short getHorse_power() {
        return horse_power;
    }

    public void setHorse_power(Short horse_power) {
        this.horse_power = horse_power;
    }
}
