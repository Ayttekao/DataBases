package com.example.kursachdb.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer brand_id;

    public Brand(String name_brand) {
        this.name_brand = name_brand;
    }

    private String name_brand;

    public Brand() {

    }

    public Integer getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(Integer brand_id) {
        this.brand_id = brand_id;
    }

    public String getName_brand() {
        return name_brand;
    }

    public void setName_brand(String name_brand) {
        this.name_brand = name_brand;
    }
}
