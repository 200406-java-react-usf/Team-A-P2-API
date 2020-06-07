package com.revature.p2.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "Cargo")
@Table(name = "cargo", uniqueConstraints = {
        @UniqueConstraint(columnNames = "good_id"),
        @UniqueConstraint(columnNames = "user_id")
})
public class Cargo implements Serializable {

    @Id
    @Column(name = "good_id", unique = true, nullable = false)
    private int id;

    @Id
    @Column(name = "user_id", unique = true, nullable = false)
    private int userId;

    @Column(name = "good_quantity", nullable = false)
    private int quantity;

    @Column(name = "cost_of_goods", nullable = false)
    private int costOfGoods;

    public Cargo() {
        super();
    }

    public Cargo(int userId, int quantity, int costOfGoods) {
        this.userId = userId;
        this.quantity = quantity;
        this.costOfGoods = costOfGoods;
    }

    public Cargo(int id, int userId, int quantity, int costOfGoods) {
        this.id = id;
        this.userId = userId;
        this.quantity = quantity;
        this.costOfGoods = costOfGoods;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCostOfGoods() {
        return costOfGoods;
    }

    public void setCostOfGoods(int costOfGoods) {
        this.costOfGoods = costOfGoods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cargo cargo = (Cargo) o;
        return id == cargo.id &&
                userId == cargo.userId &&
                quantity == cargo.quantity &&
                costOfGoods == cargo.costOfGoods;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, quantity, costOfGoods);
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "id=" + id +
                ", userId=" + userId +
                ", quantity=" + quantity +
                ", costOfGoods=" + costOfGoods +
                '}';
    }
}