package com.revature.p2.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="planets")
public class Planet {

    @Id
    @Column(name="planet_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="planet_name", nullable=false,unique=true)
    private String name;

    public Planet() {
        super();
    }

    public Planet(String name) {
        this.name = name;
    }

    public Planet(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public Planet setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Planet setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planet planet = (Planet) o;
        return id == planet.id &&
                Objects.equals(name, planet.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Planet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
