package com.revature.p2.models;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity(name = "Cargo")
@Table(name = "cargo", uniqueConstraints = {
        @UniqueConstraint(columnNames = "good_id"),
        @UniqueConstraint(columnNames = "user_id")
})


public class Cargo {

    @Id
    @Column(name = "good_id", unique = true, nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id", unique = true, nullable = false)
    private int userId;

    @Column(name = "good_quantity", nullable = false)
    private int quantity;

    @Column(name = "cost_of_goods", nullable = false)
    private int costOfGoods;

    @OneToOne(mappedBy = "cargo")
    private User user;

//    @JoinColumn
//    @ManyToOne
//    private Good good;

    @OneToMany(mappedBy = "goods")
    private Set<Cargo> cargos;


    public Cargo() {
        super();
    }

    public Cargo(int userId, int quantity, int costOfGoods, User user, Set<Cargo> cargos) {
        this.userId = userId;
        this.quantity = quantity;
        this.costOfGoods = costOfGoods;
        this.user = user;
        this.cargos = cargos;
    }

    public Cargo(int id, int userId, int quantity, int costOfGoods, User user, Set<Cargo> cargos) {
        this.id = id;
        this.userId = userId;
        this.quantity = quantity;
        this.costOfGoods = costOfGoods;
        this.user = user;
        this.cargos = cargos;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Cargo> getCargos() {
        return cargos;
    }

    public void setCargos(Set<Cargo> cargos) {
        this.cargos = cargos;
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
                Objects.equals(user, cargo.user) &&
                Objects.equals(cargos, cargo.cargos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, quantity, costOfGoods, user, cargos);
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "id=" + id +
                ", userId=" + userId +
                ", quantity=" + quantity +
                ", costOfGoods=" + costOfGoods +
                ", user=" + user +
                ", cargos=" + cargos +
                '}';
    }
}