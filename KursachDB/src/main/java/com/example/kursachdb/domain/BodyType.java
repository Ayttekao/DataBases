package com.example.kursachdb.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BodyType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer body_type_id;

    public BodyType(String name_body_type) {
        this.name_body_type = name_body_type;
    }

    private String name_body_type;

    public BodyType() {}

    public String getName_body_type() {
        return name_body_type;
    }

    public void setName_body_type(String name_body_type) {
        this.name_body_type = name_body_type;
    }

    public Integer getBody_type_id() {
        return body_type_id;
    }

    public void setBody_type_id(Integer body_type_id) {
        this.body_type_id = body_type_id;
    }
}
