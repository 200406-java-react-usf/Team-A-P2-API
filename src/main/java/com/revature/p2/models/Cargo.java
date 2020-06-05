package com.revature.p2.models;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="cargo", uniqueConstraints = {
        @UniqueConstraint(columnNames = "good_id"),
        @UniqueConstraint(columnNames = "user_id")
})


public class Cargo {

    @Id
    @Column(name = "good_id", unique = true, nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id", nullable = true, unique = true)
    private int userId;

    @Column(name = "good_quantity", nullable = true)
    private int quantity;

    @Column(name = "cost_of_goods", nullable = false)
    private int costOfGoods;

    @Column(name = "cargo_planet_id", nullable = true, unique = true)
    private int planetId;

    @Column(name = "cargo_avg_price", nullable = true)
    private float price;

    @Column(name = "cargo_quantity", nullable = true)
    private int cargoQuantity;

    @Column(name = "cargo_user_id")
    private int cargoUserId;

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "cargo_goods", joinColumns = {@JoinColumn(referencedColumnName = "user_id")}
            , inverseJoinColumns = {@JoinColumn(referencedColumnName = "good_id")})
    private Set<Good> goods;


    public Cargo() {
        super();
    }

    public Cargo(int userId, int quantity, int costOfGoods, int planetId, float price, int cargoQuantity, int cargoUserId, String name, Set<Good> goods) {
        this.userId = userId;
        this.quantity = quantity;
        this.costOfGoods = costOfGoods;
        this.planetId = planetId;
        this.price = price;
        this.cargoQuantity = cargoQuantity;
        this.cargoUserId = cargoUserId;
        this.name = name;
        this.goods = goods;
    }

    public Cargo(int id, int userId, int quantity, int costOfGoods, int planetId, float price, int cargoQuantity, int cargoUserId, String name, Set<Good> goods) {
        this.id = id;
        this.userId = userId;
        this.quantity = quantity;
        this.costOfGoods = costOfGoods;
        this.planetId = planetId;
        this.price = price;
        this.cargoQuantity = cargoQuantity;
        this.cargoUserId = cargoUserId;
        this.name = name;
        this.goods = goods;
    }

    public int getId() {
        return id;
    }

    public Cargo setId(int id) {
        this.id = id;
        return this;
    }

    public int getUserId() {
        return userId;
    }

    public Cargo setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public Cargo setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public int getCostOfGoods() {
        return costOfGoods;
    }

    public Cargo setCostOfGoods(int costOfGoods) {
        this.costOfGoods = costOfGoods;
        return this;
    }

    public int getPlanetId() {
        return planetId;
    }

    public Cargo setPlanetId(int planetId) {
        this.planetId = planetId;
        return this;
    }

    public float getPrice() {
        return price;
    }

    public Cargo setPrice(float price) {
        this.price = price;
        return this;
    }

    public int getCargoQuantity() {
        return cargoQuantity;
    }

    public Cargo setCargoQuantity(int cargoQuantity) {
        this.cargoQuantity = cargoQuantity;
        return this;
    }

    public int getCargoUserId() {
        return cargoUserId;
    }

    public Cargo setCargoUserId(int cargoUserId) {
        this.cargoUserId = cargoUserId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Cargo setName(String name) {
        this.name = name;
        return this;
    }

    public Set<Good> getGoods() {
        return goods;
    }

    public Cargo setGoods(Set<Good> goods) {
        this.goods = goods;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cargo cargo = (Cargo) o;
        return id == cargo.id &&
                userId == cargo.userId &&
                quantity == cargo.quantity &&
                costOfGoods == cargo.costOfGoods &&
                planetId == cargo.planetId &&
                Float.compare(cargo.price, price) == 0 &&
                cargoQuantity == cargo.cargoQuantity &&
                cargoUserId == cargo.cargoUserId &&
                Objects.equals(name, cargo.name) &&
                Objects.equals(goods, cargo.goods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, quantity, costOfGoods, planetId, price, cargoQuantity, cargoUserId, name, goods);
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "id=" + id +
                ", userId=" + userId +
                ", quantity=" + quantity +
                ", costOfGoods=" + costOfGoods +
                ", planetId=" + planetId +
                ", price=" + price +
                ", cargoQuantity=" + cargoQuantity +
                ", cargoUserId=" + cargoUserId +
                ", name='" + name + '\'' +
                ", goods=" + goods +
                '}';
    }
}