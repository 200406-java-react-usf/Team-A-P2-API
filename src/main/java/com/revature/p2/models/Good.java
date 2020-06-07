package com.revature.p2.models;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "Good")
@Table(name = "goods", uniqueConstraints = {
        @UniqueConstraint(columnNames = "good_id")
})
public class Good {

    @Id
    @Column(name = "good_id", unique = true, nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name = "good_name", nullable = false, unique = true, length = 35)
    private String name;

    @Column(name = "good_description", nullable = false, length = 256)
    private String description;

    @Column(name = "good_base_price", nullable = false)
    private int price;

    public Good() {
        super();
    }

    public Good(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Good(int id, String name, String description, int price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
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
        Good good = (Good) o;
        return id == good.id &&
                price == good.price &&
                Objects.equals(name, good.name) &&
                Objects.equals(description, good.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price);
    }

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}