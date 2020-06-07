package com.revature.p2.web.dtos;

import com.revature.p2.models.PlanetGood;

import java.util.Objects;

public class PlanetGoodDTO {

    private int id;
    private int planetId;
    private float priceMod;

    public PlanetGoodDTO() {
        super();
    }

    public PlanetGoodDTO(PlanetGood planetGood) {
        this.id = planetGood.getId();
        this.planetId = planetGood.getPlanetId();
        this.priceMod = planetGood.getPriceMod();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getplanetId() {
        return planetId;
    }

    public void setPlanetId(int planetId) {
        this.planetId = planetId;
    }

    public float getPriceMod() {
        return priceMod;
    }

    public void setPriceMod(float priceMod) {
        this.priceMod = priceMod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com.revature.p2.web.dtos.PlanetGoodDTO planetGoodDTO = (com.revature.p2.web.dtos.PlanetGoodDTO) o;
        return id == planetGoodDTO.id &&
                planetId == planetGoodDTO.planetId &&
                priceMod == planetGoodDTO.priceMod;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, planetId, priceMod);
    }

    @Override
    public String toString() {
        return "PlanetGoodDTO{" +
                "id=" + id +
                ", planetId=" + planetId +
                ", priceMod=" + priceMod +
                '}';
    }

}

