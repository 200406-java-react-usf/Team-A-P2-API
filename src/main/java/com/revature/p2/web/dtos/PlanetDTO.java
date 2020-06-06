package com.revature.p2.web.dtos;

import com.revature.p2.models.Planet;

import java.util.Objects;

public class PlanetDTO {

    private int id;
    private String name;
    private float priceModifier;

    public PlanetDTO() {
        super();
    }

    public PlanetDTO(Planet planet) {
        this.id = planet.getId();
        this.name = planet.getName();
        this.priceModifier = planet.getPriceModifier();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPriceModifier() {
        return priceModifier;
    }

    public void setPriceModifier(float priceModifier) {
        this.priceModifier = priceModifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlanetDTO planetDTO = (PlanetDTO) o;
        return id == planetDTO.id &&
                Float.compare(planetDTO.priceModifier, priceModifier) == 0 &&
                Objects.equals(name, planetDTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, priceModifier);
    }

    @Override
    public String toString() {
        return "PlanetDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", priceModifier=" + priceModifier +
                '}';
    }
}