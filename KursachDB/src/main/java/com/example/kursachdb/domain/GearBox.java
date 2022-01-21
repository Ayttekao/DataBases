package com.example.kursachdb.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GearBox {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Short numberOfGears;

    private String switchingType;

    public GearBox() {
    }

    public GearBox(String switchingType) {
        this.switchingType = switchingType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getNumberOfGears() {
        return numberOfGears;
    }

    public void setNumberOfGears(Short numberOfGears) {
        this.numberOfGears = numberOfGears;
    }

    public String getSwitchingType() {
        return switchingType;
    }

    public void setSwitchingType(String switchingType) {
        this.switchingType = switchingType;
    }
}
