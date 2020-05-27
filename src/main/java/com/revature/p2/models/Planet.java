package com.revature.p2.models;

import java.util.Objects;

public class Planet {

    private int id;

    private String name;

    public Planet() {
        super();
    }

    public Planet(String name) {
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
