package com.revature.p2.web.dtos;

import com.revature.p2.models.Good;

import java.util.Objects;

public class GoodDTO {

    private int id;
    private String name;
    private String description;
    private int price;

    public GoodDTO() {
        super();
    }

    public GoodDTO(Good good) {
        this.id = good.getId();
        this.name = good.getName();
        this.description = good.getDescription();
        this.price = good.getPrice();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodDTO goodDTO = (GoodDTO) o;
        return id == goodDTO.id &&
                price == goodDTO.price &&
                Objects.equals(name, goodDTO.name) &&
                Objects.equals(description, goodDTO.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price);
    }

    @Override
    public String toString() {
        return "GoodDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}