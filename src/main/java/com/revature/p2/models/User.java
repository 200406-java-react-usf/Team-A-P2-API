package com.revature.p2.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="users")
public class User implements Serializable {

    @Id @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Column(name="cargo_space")
    private int cargoSpace;

    @Column
    private double currency;

    @Id @Column(name="location", nullable = false, unique = true)
    private int locationId;

    @Id @Column(name="good_id", nullable = false, unique = true)
    private int goodId;

    @Column(name="good_avg_price", nullable = false)
    private double avgGoodPrice;

    @Column(name="good_quantity", nullable = false)
    private int quantity;

    public User() { super();}

    public User(String username, String password, int cargoSpace, double currency, int locationId, int goodId, double avgGoodPrice, int quantity) {
        this.username = username;
        this.password = password;
        this.cargoSpace = cargoSpace;
        this.currency = currency;
        this.locationId = locationId;
        this.goodId = goodId;
        this.avgGoodPrice = avgGoodPrice;
        this.quantity = quantity;
        this.role = UserRole.USER;
    }

    public User(int id, String username, String password, int cargoSpace, double currency, int locationId, int goodId, double avgGoodPrice, int quantity, UserRole role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.cargoSpace = cargoSpace;
        this.currency = currency;
        this.locationId = locationId;
        this.goodId = goodId;
        this.avgGoodPrice = avgGoodPrice;
        this.quantity = quantity;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public int getCargoSpace() {
        return cargoSpace;
    }

    public User setCargoSpace(int cargoSpace) {
        this.cargoSpace = cargoSpace;
        return this;
    }

    public double getCurrency() {
        return currency;
    }

    public User setCurrency(double currency) {
        this.currency = currency;
        return this;
    }

    public int getLocationId() {
        return locationId;
    }

    public User setLocationId(int locationId) {
        this.locationId = locationId;
        return this;
    }

    public int getGoodId() {
        return goodId;
    }

    public User setGoodId(int goodId) {
        this.goodId = goodId;
        return this;
    }

    public double getAvgGoodPrice() {
        return avgGoodPrice;
    }

    public User setAvgGoodPrice(double avgGoodPrice) {
        this.avgGoodPrice = avgGoodPrice;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public User setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                role == user.role &&
                cargoSpace == user.cargoSpace &&
                Double.compare(user.currency, currency) == 0 &&
                locationId == user.locationId &&
                goodId == user.goodId &&
                Double.compare(user.avgGoodPrice, avgGoodPrice) == 0 &&
                quantity == user.quantity &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, role, cargoSpace, currency, locationId, goodId, avgGoodPrice, quantity);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", cargoSpace=" + cargoSpace +
                ", currency=" + currency +
                ", locationId=" + locationId +
                ", goodId=" + goodId +
                ", avgGoodPrice=" + avgGoodPrice +
                ", quantity=" + quantity +
                '}';
    }
}