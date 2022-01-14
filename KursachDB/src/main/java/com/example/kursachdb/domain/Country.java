package com.example.kursachdb.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer country_id;

    public Country(String name) {
        this.name = name;
    }

    private String name;

    public Country() {

    }

    public Integer getCountry_id() {
        return country_id;
    }

    public void setCountry_id(Integer country_id) {
        this.country_id = country_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
