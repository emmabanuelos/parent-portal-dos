package com.emmabanuelos.TakeAHikeKid.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Parks {

    @Id
    @GeneratedValue
    private int id;


    private String name;
    private String location;
    private int difficulty;


    // Initialize a unique ID.
    public Parks() {

    }

    // Initialize the id and value fields.
    public Parks(String aName, String aLocation, int aDifficulty) {
        this();
        name = aName;
        location = aLocation;
        difficulty = aDifficulty;

    }

    // Custom toString method.
    @Override
    public String toString(){
        String output = "";
        if (name.equals("")){
            name = "Data not available";
        }

        if (location.equals("") || location == null){
            location = "Data not available";
        }



        output = String.format(
                "Name: %s\n" +
                "Location: %s\n" +
                "Difficulty: %s\n" ,  name, location, difficulty );
        return output;
    }

    // Custom equals and hashCode methods. Two Job objects are "equal" when their id fields match.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Parks)) return false;
        Parks park = (Parks) o;
        return id == park.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    // Getters and setters.

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
}


