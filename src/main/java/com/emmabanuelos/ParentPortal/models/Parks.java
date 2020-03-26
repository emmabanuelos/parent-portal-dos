package com.emmabanuelos.ParentPortal.models;

import java.util.Objects;

public class Parks {
    private int id;
    private static int nextId = 1;

    private String name;
    private TrailName trailName;
    private Location location;
    private Difficulty difficulty;
    private TrailType trailType;
    private TrailDistance trailDistance;

    // Initialize a unique ID.
    public Parks() {
        id = nextId;
        nextId++;
    }

    // Initialize the id and value fields.
    public Parks(String aName, TrailName aTrailName, Location aLocation, Difficulty aDifficulty, TrailType aTrailType, TrailDistance trailDistance) {
        this();
        name = aName;
        trailName = aTrailName;
        location = aLocation;
        difficulty = aDifficulty;
        trailType = aTrailType;
        trailDistance =trailDistance;
    }

    // Custom toString method.
    @Override
    public String toString(){
        String output = "";
        if (name.equals("")){
            name = "Data not available";
        }
        if (trailName.getValue().equals("") || trailName.getValue() == null){
            trailName.setValue("Data not available");
        }
        if (location.getValue().equals("") || location.getValue() == null){
            location.setValue("Data not available");
        }
        if (difficulty.getValue().equals("") || difficulty.getValue() == null){
            difficulty.setValue("Data not available");
        }
        if (trailType.getValue().equals("") || trailType.getValue() == null){
            trailType.setValue("Data not available");
        }
        if (trailDistance.getValue().equals("") || trailDistance.getValue() == null){
            trailDistance.setValue("Data not available");
        }

        output = String.format("\nID: %d\n" +
                "Name: %s\n" +
                "Trail Name : %s\n" +
                "Location: %s\n" +
                "Difficulty: %s\n" +
                "Trail Type: %s\n",
                "Trail Distance: %s\n" id, name, trailName, location, difficulty, trailType, trailDistance);
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

    public TrailName getTrailName() {
        return trailName;
    }

    public void setTrailName(TrailName trailName) {
        this.trailName = trailName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public TrailType getCoreCompetency() {
        return trailType;
    }

    public void setTrailType(TrailType trailType) {
        this.trailType = trailType;
    }

    public TrailDistance getTrailDistance() {
        return trailDistance;
    }

    public void setTrailDistance(TrailDistance trailDistance) {
        this.trailDistance = trailDistance;
    }
}


