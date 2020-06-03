package com.revature.p2.web.dtos;

import com.revature.p2.models.User;
import com.revature.p2.models.UserRole;

import java.util.Objects;

public class UserDTO {

    private int id;
    private String username;
    private UserRole role;
    private int cargoSpace;
    private Number currency;
    private int locationId;
    private int goodId;
    private Number avgGoodPrice;
    private int quantity;

    public UserDTO() {
        super();
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.role = user.getRole();
        this.cargoSpace = user.getCargoSpace();
        this.currency = user.getCurrency();
        this.locationId = user.getLocationId();
        this.goodId = user.getGoodId();
        this.avgGoodPrice = user.getAvgGoodPrice();
        this.quantity = user.getQuantity();
    }

    public int getId() {
        return id;
    }

    public UserDTO setId(int id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserDTO setUsername(String username) {
        this.username = username;
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

    public UserDTO setCargoSpace(int cargoSpace) {
        this.cargoSpace = cargoSpace;
        return this;
    }

    public Number getCurrency() {
        return currency;
    }

    public UserDTO setCurrency(Number currency) {
        this.currency = currency;
        return this;
    }

    public int getLocationId() {
        return locationId;
    }

    public UserDTO setLocationId(int locationId) {
        this.locationId = locationId;
        return this;
    }

    public int getGoodId() {
        return goodId;
    }

    public UserDTO setGoodId(int goodId) {
        this.goodId = goodId;
        return this;
    }

    public Number getAvgGoodPrice() {
        return avgGoodPrice;
    }

    public UserDTO setAvgGoodPrice(Number avgGoodPrice) {
        this.avgGoodPrice = avgGoodPrice;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public UserDTO setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return id == userDTO.id &&
                role == userDTO.role &&
                cargoSpace == userDTO.cargoSpace &&
                locationId == userDTO.locationId &&
                goodId == userDTO.goodId &&
                quantity == userDTO.quantity &&
                Objects.equals(username, userDTO.username) &&
                Objects.equals(currency, userDTO.currency) &&
                Objects.equals(avgGoodPrice, userDTO.avgGoodPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, role, cargoSpace, currency, locationId, goodId, avgGoodPrice, quantity);
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
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