package com.flobiz.platformservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Company {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String gstin;

    public Company() {
    }

    public Company(String name, String gstin) {
        this.name = name;
        this.gstin = gstin;
    }

    public Company(UUID id, String name, String gstin) {
        this.id = id;
        this.name = name;
        this.gstin = gstin;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGstin() {
        return gstin;
    }

    public void setGstin(String gstin) {
        this.gstin = gstin;
    }
}
