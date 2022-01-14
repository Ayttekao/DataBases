package com.example.kursachdb.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Capacity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer capacity_id;

    public Capacity(Short number_of_seats) {
        this.number_of_seats = number_of_seats;
    }

    private Short number_of_seats;

    public Capacity() {

    }

    public Integer getCapacity_id() {
        return capacity_id;
    }

    public void setCapacity_id(Integer capacity_id) {
        this.capacity_id = capacity_id;
    }

    public short getNumber_of_seats() {
        return number_of_seats;
    }

    public void setNumber_of_seats(short number_of_seats) {
        this.number_of_seats = number_of_seats;
    }
}
