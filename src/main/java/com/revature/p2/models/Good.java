package com.revature.p2.models;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

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

    @Column(name = "good_description", nullable = false, unique = true, length = 256)
    private String description;

    @Column(name = "good_base_price", nullable = false)
    private int price;

    @ManyToMany(mappedBy = "goods")
    private Set<Cargo> cargos;

    @ManyToMany(mappedBy = "goods")
    private Set<Planet> planets;


    public Good() {
        super();
    }

    public Good(String name, String description, int price, Set<Cargo> cargos) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.cargos = cargos;
    }

    public Good(int id, String name, String description, int price, Set<Cargo> cargos) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.cargos = cargos;
    }

    public int getId() {
        return id;
    }

    public Good setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Good setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Good setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public Good setPrice(int price) {
        this.price = price;
        return this;
    }

    public Set<Cargo> getCargos() {
        return cargos;
    }

    public Good setCargos(Set<Cargo> cargos) {
        this.cargos = cargos;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Good good = (Good) o;
        return id == good.id &&
                price == good.price &&
                Objects.equals(name, good.name) &&
                Objects.equals(description, good.description) &&
                Objects.equals(cargos, good.cargos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, cargos);
    }

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", cargos=" + cargos +
                '}';
    }
}