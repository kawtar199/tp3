package com.example.demo.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "country")
public class Country {
    @Id
    @Column(name = "Code", nullable = false, length = 3)
    private String code;

    @Lob
    @Column(name = "Name")
    private String name;

    @Lob
    @Column(name = "Continent")
    private String continent;

    @Lob
    @Column(name = "Region")
    private String region;

    @Lob
    @Column(name = "LocalName")
    private String localName;

    @Column(name = "Capital")
    private Integer capital;

    @Lob
    @Column(name = "Code2")
    private String code2;

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

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public Integer getCapital() {
        return capital;
    }

    public void setCapital(Integer capital) {
        this.capital = capital;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

}