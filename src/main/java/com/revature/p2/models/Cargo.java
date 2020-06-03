package com.revature.p2.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="Cargo")
public class Cargo {

    @Id
    @Column(name="cargo_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="cargo_user_id", nullable = true, unique = true)
    private int userId;

    @Column(name="cargo_planet_id", nullable = true, unique = true)
    private int planetId;

    @Column(name="cargo_name", nullable = false, unique = true)
    private String name;

    @Column(name="cargo_quantity", nullable = true)
    private int quantity;

    @Column(name="cargo_avg_price", nullable = true)
    private float price;

    public Cargo(String name, int quantity, float price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public Cargo(int id, int uId, int pId, String name, String description, int price) {
        this.id = id;
        this.userId = uId;
        this.planetId = pId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }
    public int getUserId() {
        return userId;
    }
    public int getplanetId() {
        return planetId;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getAvgPrice() {
        return price;
    }

    public Cargo setId(int id) {
        this.id = id;
        return this;
    }
    public Cargo setUserId(int id) {
        this.userId = id;
        return this;
    }
    public Cargo setPlanetId(int id) {
        this.planetId = id;
        return this;
    }
    public Cargo setName(String name) {
        this.name = name;
        return this;
    }

    public Cargo setQuantity() {
        this.quantity = quantity;
        return this;
    }

    public Cargo setAvgPrice() {
        this.price = price;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cargo cargo = (Cargo) o;
        return id == cargo.id &&
                price == cargo.price &&
                Objects.equals(name, cargo.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, quantity, price);
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity='" + quantity + '\'' +
                ", avg price=" + price +
                '}';
    }
}