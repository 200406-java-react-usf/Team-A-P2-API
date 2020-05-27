package com.revature.p2.models;

import java.util.Objects;

public class User {

    private int id;

    private String username;

    private String password;

    private int roleId;

    private int cargoSpace;

    private double currency;

    private int locationId;

    private int goodId;

    private double avgGoodPrice;

    private int quantity;

    public User() {

    }

    public User(String username, String password, int roleId, int cargoSpace, double currency, int locationId, int goodId, double avgGoodPrice, int quantity) {
        this.username = username;
        this.password = password;
        this.roleId = roleId;
        this.cargoSpace = cargoSpace;
        this.currency = currency;
        this.locationId = locationId;
        this.goodId = goodId;
        this.avgGoodPrice = avgGoodPrice;
        this.quantity = quantity;
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

    public int getRoleId() {
        return roleId;
    }

    public User setRoleId(int roleId) {
        this.roleId = roleId;
        return this;
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
                roleId == user.roleId &&
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
        return Objects.hash(id, username, password, roleId, cargoSpace, currency, locationId, goodId, avgGoodPrice, quantity);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roleId=" + roleId +
                ", cargoSpace=" + cargoSpace +
                ", currency=" + currency +
                ", locationId=" + locationId +
                ", goodId=" + goodId +
                ", avgGoodPrice=" + avgGoodPrice +
                ", quantity=" + quantity +
                '}';
    }
}
