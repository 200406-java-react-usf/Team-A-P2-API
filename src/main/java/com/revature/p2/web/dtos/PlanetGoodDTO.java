package com.revature.p2.web.dtos;

import com.revature.p2.models.PlanetGood;

import java.util.Objects;

public class PlanetGoodDTO {

    private int planetId;
    private int goodId;
    private float priceModifier;

    public PlanetGoodDTO() {
        super();
    }

    public PlanetGoodDTO(int planetId, int goodId, float priceModifier) {
        this.planetId = planetId;
        this.goodId = goodId;
        this.priceModifier = priceModifier;
    }

    public PlanetGoodDTO(PlanetGood pg) {
        this.planetId = pg.getPlanetId();
        this.goodId = pg.getId();
        this.priceModifier = pg.getPriceMod();
    }

    public int getPlanetId() {
        return planetId;
    }

    public void setPlanetId(int planetId) {
        this.planetId = planetId;
    }

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
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
        PlanetGoodDTO that = (PlanetGoodDTO) o;
        return planetId == that.planetId &&
                goodId == that.goodId &&
                Float.compare(that.priceModifier, priceModifier) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(planetId, goodId, priceModifier);
    }

    @Override
    public String toString() {
        return "PlanetGoodDTO{" +
                "planetId=" + planetId +
                ", goodId=" + goodId +
                ", priceModifier=" + priceModifier +
                '}';
    }
}
