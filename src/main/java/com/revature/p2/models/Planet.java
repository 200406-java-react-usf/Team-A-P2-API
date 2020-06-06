package com.revature.p2.models;

import com.sun.istack.NotNull;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="planets", uniqueConstraints = {
        @UniqueConstraint(columnNames = "planet_id"),
        @UniqueConstraint(columnNames = "planet_name")
})


public class Planet {

    @Id
    @Column(name = "planet_id", unique = true, nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
//    @OneToMany(mappedBy = "locationId")
    private int id;
//    private Set<User> users;

    @Column(name = "planet_name", nullable = false, unique = true, length = 35)
    private String name;

    @Column(name = "price_modifier", nullable = false)
    private float priceModifier;

    @OneToMany(mappedBy = "locationId")
    private Set<User> users;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "planet_goods",
            joinColumns = {@JoinColumn(name = "planet_id")},
            inverseJoinColumns = {@JoinColumn(name = "good_id")})
    private Set<Good> goods;


    public Planet() {
        super();
    }

    public Planet(String name, float priceModifier, Set<User> users, Set<Good> goods) {
        this.name = name;
        this.priceModifier = priceModifier;
        this.users = users;
        this.goods = goods;
    }

    public Planet(int id, String name, float priceModifier, Set<User> users, Set<Good> goods) {
        this.id = id;
        this.name = name;
        this.priceModifier = priceModifier;
        this.users = users;
        this.goods = goods;
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

    public float getPriceModifier() {
        return priceModifier;
    }

    public Planet setPriceModifier(float priceModifier) {
        this.priceModifier = priceModifier;
        return this;
    }

    public Set<User> getUsers() {
        return users;
    }

    public Planet setUsers(Set<User> users) {
        this.users = users;
        return this;
    }

    public Set<Good> getGoods() {
        return goods;
    }

    public Planet setGoods(Set<Good> goods) {
        this.goods = goods;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planet planet = (Planet) o;
        return id == planet.id &&
                Float.compare(planet.priceModifier, priceModifier) == 0 &&
                Objects.equals(name, planet.name) &&
                Objects.equals(users, planet.users) &&
                Objects.equals(goods, planet.goods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, priceModifier, users, goods);
    }

    @Override
    public String toString() {
        return "Planet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", priceModifier=" + priceModifier +
                ", users=" + users +
                ", goods=" + goods +
                '}';
    }

}