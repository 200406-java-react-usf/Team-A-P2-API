package com.revature.p2.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "User")
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id"),
        @UniqueConstraint(columnNames = "username")})


public class User implements Serializable {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username", nullable = false, unique = true, length = 20)
    private String username;

    @Column(name = "password", nullable = false, length = 20)
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Column(name = "cargo_space", nullable = false)
    private int cargoSpace;

    @Column(name = "currency")
    private double currency;

    @Column(name = "location", nullable = false, columnDefinition = "from Planet p where p.id = :location")
    private int location;

//    @JoinColumn
//    @ManyToOne(cascade={
//            CascadeType.REMOVE, CascadeType.MERGE,
//            CascadeType.PERSIST, CascadeType.DETACH
//    })
//    private Planet planet;


    public User() {
        super();}

    public User(String username, String password, int cargoSpace, double currency, int location) {
        this.username = username;
        this.password = password;
        this.cargoSpace = cargoSpace;
        this.currency = currency;
        this.location = location;
        this.role = UserRole.USER;
    }

    public User(int id, String username, String password, int cargoSpace, double currency, int location, UserRole role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.cargoSpace = cargoSpace;
        this.currency = currency;
        this.location = location;
        this.role = UserRole.USER;
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

    public User setRole(UserRole role) {
        this.role = role;
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

    public int getLocation() {
        return location;
    }

    public User setLocationId(int location) {
        this.location = location;
        return this;
    }

//    public Planet getPlanet() {
//        return planet;
//    }
//
//    public User setPlanet(Planet planet) {
//        this.planet = planet;
//        return this;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                cargoSpace == user.cargoSpace &&
                Double.compare(user.currency, currency) == 0 &&
                location == user.location &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                role == user.role;
//        &&
//                Objects.equals(planet, user.planet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, role, cargoSpace, currency, location);
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
                ", location=" + location +
                '}';
    }
}