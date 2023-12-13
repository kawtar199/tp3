package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "city")
public class City {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "Name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CountryCode")
    private Country countryCode;

    @Lob
    @Column(name = "District")
    private String district;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(Country countryCode) {
        this.countryCode = countryCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

}
