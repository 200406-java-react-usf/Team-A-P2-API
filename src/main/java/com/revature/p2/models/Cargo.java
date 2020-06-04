package com.revature.p2.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="cargo")
public class Cargo {

    @Id
    @Column(name="good_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="good_quantity", nullable = true)
    private int quantity;

    @Column(name = "cost_of_goods", nullable = false)
    private int costOfGoods;

    @Column(name="user_id", nullable = true, unique = true)
    private int userId;

//    @JoinColumn(mappedBy= "goods", nullable = false, unique = true)

    private String name;

//    @Column(name="cargo_planet_id", nullable = true, unique = true)
//    private int planetId;

//    @Column(name="cargo_avg_price", nullable = true)
//    private float price;

    public Cargo(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public Cargo(int id, int uId, String name, int quantity) {
        this.id = id;
        this.userId = uId;
        this.name = name;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }
    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public Cargo setId(int id) {
        this.id = id;
        return this;
    }
    public Cargo setUserId(int id) {
        this.userId = id;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cargo cargo = (Cargo) o;
        return id == cargo.id &&
                Objects.equals(name, cargo.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, quantity);
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }
}