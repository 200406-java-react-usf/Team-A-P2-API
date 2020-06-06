package com.revature.p2.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity(name = "Planet_Goods")
@Table(name = "planet_goods", uniqueConstraints = {
        @UniqueConstraint(columnNames = "good_id"),
        @UniqueConstraint(columnNames = "planet_id")
})
public class PlanetGood implements Serializable {

    @Id
    @Column(name = "good_id", unique = true, nullable = false)
    private int id;

    @Id
    @Column(name = "planet_id", unique = true, nullable = false)
    private int planetId;

    @Column(name = "price_modifier")
    private float priceMod;


    public PlanetGood() {
        super();
    }

    public PlanetGood(int goodId, float priceMod) {
        this.id = goodId;
        this.priceMod = priceMod;
    }

    public PlanetGood(int planetId, int goodId, float priceMod) {
        this.planetId = planetId;
        this.id = goodId;
        this.priceMod = priceMod;
    }

    public int getId() {
        return id;
    }

    public PlanetGood setId(int id) {
        this.id = id;
        return this;
    }

    public int getPlanetId() {
        return planetId;
    }

    public PlanetGood setPlanetId(int planetId) {
        this.planetId = planetId;
        return this;
    }

    public float getPriceMod() {
        return priceMod;
    }

    public PlanetGood setQuantity(float priceMod) {
        this.priceMod = priceMod;
        return this;
    }

//    public Set<Good> getGoods() {
//        return goods;
//    }
//
//    public PlanetGood setGoods(Set<Good> goods) {
//        this.goods = goods;
//        return this;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlanetGood planetGood = (PlanetGood) o;
        return id == planetGood.id &&
                planetId == planetGood.planetId &&
                priceMod == planetGood.priceMod;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, planetId, priceMod);
    }

    @Override
    public String toString() {
        return "PlanetGood{" +
                "id=" + id +
                ", planetId=" + planetId +
                ", priceMod=" + priceMod +
                '}';
    }
}