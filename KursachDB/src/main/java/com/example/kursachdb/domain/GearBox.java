package com.example.kursachdb.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GearBox {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer gear_box_id;

    private Short number_of_gears;

    public GearBox(String switching_type) {
        this.switching_type = switching_type;
    }

    private String switching_type;

    public GearBox() {

    }

    public Integer getGear_box_id() {
        return gear_box_id;
    }

    public void setGear_box_id(Integer gear_box_id) {
        this.gear_box_id = gear_box_id;
    }

    public Short getNumber_of_gears() {
        return number_of_gears;
    }

    public void setNumber_of_gears(Short number_of_gears) {
        this.number_of_gears = number_of_gears;
    }

    public String getSwitching_type() {
        return switching_type;
    }

    public void setSwitching_type(String switching_type) {
        this.switching_type = switching_type;
    }
}
