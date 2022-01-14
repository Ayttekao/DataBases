package com.example.kursachdb.domain;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "car", schema = "public")
@Data
public class Car {
    public Car(){}

    public Car(Brand brand, String model, BodyType bodyType,
               Layout layout, Capacity capacity, Engine engine,
               GearBox gearBox, Country country, Double price) {
        this.brand = brand;
        this.model = model;
        this.bodyType = bodyType;
        this.layout = layout;
        this.capacity = capacity;
        this.engine = engine;
        this.gearBox = gearBox;
        this.country = country;
        this.price = price;
    }

    @PrePersist
    void preInsert() {
        if (this.picture == null)
        {
            this.picture = new Picture();
            this.picture.setPicture_id(1);
        }
        if (this.picture.getPicture_id() == null) {
            this.picture.setPicture_id(1);
        }
    }

    @Id
    @Column(name = "car_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer car_id;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @Column(name = "model", unique = true)
    private String model;

    @ManyToOne
    @JoinColumn(name = "body_type_id")
    private BodyType bodyType;

    @ManyToOne
    @JoinColumn(name = "layout_id")
    private Layout layout;

    @ManyToOne
    @JoinColumn(name = "capacity_id")
    private Capacity capacity;

    @ManyToOne
    @JoinColumn(name = "engine_id")
    private Engine engine;

    @ManyToOne
    @JoinColumn(name = "gear_box_id")
    private GearBox gearBox;

    @ManyToOne
    @JoinColumn(name = "county_id")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "picture_id")
    private Picture picture;

    @Column(name = "price")
    private Double price;
}
