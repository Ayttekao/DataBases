package com.example.kursachdb.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Capacity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Short numberOfSeats;

    public Capacity(Short numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Capacity() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public short getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(short numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
