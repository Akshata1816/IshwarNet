package com.akshata.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PredefinedMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long predefinedId;
    private String code;
    private String name;

    public Long getPredefinedId() {
        return predefinedId;
    }

    public void setPredefinedId(Long predefinedId) {
        this.predefinedId = predefinedId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
