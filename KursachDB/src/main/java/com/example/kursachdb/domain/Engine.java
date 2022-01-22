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

    private Short horsePower;

    private Double volume;

    public Engine(String name) {
        this.name = name;
    }

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

    public void setName(String name) {
        this.name = name;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double capacity) {
        this.volume = capacity;
    }

    public Short getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(Short horsePower) {
        this.horsePower = horsePower;
    }
}
