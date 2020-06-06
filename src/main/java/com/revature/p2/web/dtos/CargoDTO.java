package com.revature.p2.web.dtos;

import com.revature.p2.models.Cargo;

import java.util.Objects;

public class CargoDTO {

    private int id;
    private int userId;
    private int quantity;
    private int costOfGoods;

    public CargoDTO() {
        super();
    }

    public CargoDTO(Cargo cargo) {
        this.id = cargo.getId();
        this.userId = cargo.getUserId();
        this.quantity = cargo.getQuantity();
        this.costOfGoods = cargo.getCostOfGoods();
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
        CargoDTO cargoDTO = (CargoDTO) o;
        return id == cargoDTO.id &&
                userId == cargoDTO.userId &&
                quantity == cargoDTO.quantity &&
                costOfGoods == cargoDTO.costOfGoods;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, quantity, costOfGoods);
    }

    @Override
    public String toString() {
        return "CargoDTO{" +
                "id=" + id +
                ", userId=" + userId +
                ", quantity=" + quantity +
                ", costOfGoods=" + costOfGoods +
                '}';
    }
}