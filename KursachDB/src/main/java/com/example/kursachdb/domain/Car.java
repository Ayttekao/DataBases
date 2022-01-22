package com.example.kursachdb.domain;

import javax.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Table(name = "car", schema = "public")
@Data
public class Car {
    public Car(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car car)) return false;
        return Objects.equals(getCar_id(), car.getCar_id()) && Objects.equals(getBrand(), car.getBrand()) && Objects.equals(getModel(), car.getModel()) && Objects.equals(getBodyType(), car.getBodyType()) && Objects.equals(getLayout(), car.getLayout()) && Objects.equals(getCapacity(), car.getCapacity()) && Objects.equals(getEngine(), car.getEngine()) && Objects.equals(getGearBox(), car.getGearBox()) && Objects.equals(getCountry(), car.getCountry()) && Objects.equals(getPicture(), car.getPicture()) && Objects.equals(getPrice(), car.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCar_id(), getBrand(), getModel(), getBodyType(), getLayout(), getCapacity(), getEngine(), getGearBox(), getCountry(), getPicture(), getPrice());
    }

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
            this.picture.setId(1);
        }
        if (this.picture.getId() == null) {
            this.picture.setId(1);
        }
        if (this.description == null || this.description.length() < 1)
        {
            this.description = "Description was not added by the user";
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

    @Column(name = "description")
    private String description;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
