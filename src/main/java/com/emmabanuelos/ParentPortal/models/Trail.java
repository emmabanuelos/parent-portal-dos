package com.emmabanuelos.ParentPortal.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Trail {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private double distance;
    private String type;

    public Trail(String name, double distance, String type) {

        this.name = name;
        this.distance = distance;
        this.type = type;
    }

    public Trail() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Trail{" +
                "name='" + name + '\'' +
                ", distance=" + distance +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trail trail = (Trail) o;
        return id == trail.id &&
                Double.compare(trail.distance, distance) == 0 &&
                name.equals(trail.name) &&
                type.equals(trail.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, distance, type);
    }
}
