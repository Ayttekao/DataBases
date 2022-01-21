package com.example.kursachdb.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Engine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private Double volume;

    public Engine(String name) {
        this.name = name;
    }

    private Short horse_power;

    public Engine() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String engine_name) {
        this.name = engine_name;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double capacity) {
        this.volume = capacity;
    }

    public Short getHorse_power() {
        return horse_power;
    }

    public void setHorse_power(Short horse_power) {
        this.horse_power = horse_power;
    }
}
