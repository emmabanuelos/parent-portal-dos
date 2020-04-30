package com.emmabanuelos.TakeAHikeKid.data;

import com.emmabanuelos.TakeAHikeKid.models.Parks;

import java.util.ArrayList;

public class ParksData {
    private static Iterable<? extends Parks> allParks;

    public static ArrayList<Parks> findByColumnAndValue(String column, String value, Iterable<Parks> allParks) {

        ArrayList<Parks> results = new ArrayList<>();

        if (value.toLowerCase().equals("all")){
            return (ArrayList<Parks>) allParks;
        }

        if (column.equals("all")){
            results = findByValue(value, allParks);
            return results;
        }
        for (Parks park : allParks) {

            String aValue = getFieldValue(park, column);

            if (aValue != null && aValue.toLowerCase().contains(value.toLowerCase())) {
                results.add(park);
            }
        }

        return results;
    }

    public static String getFieldValue(Parks parks, String fieldName){
        String theValue;
        if (fieldName.equals("name")){
            theValue = parks.getName();
        } else if (fieldName.equals("trail")){
            theValue = parks.toString();
        } else {
            theValue = parks.toString();
        }

        return theValue;
    }

    /**
     * Search all Job fields for the given term.
     *
     * @param value The search term to look for.
     * @param allJobs The list of jobs to search.
     * @return      List of all jobs with at least one field containing the value.
     */




    public static ArrayList<Parks> findByValue(String value, Iterable<Parks> allJobs) {

        ArrayList<Parks> results = new ArrayList<>();
        for (Parks parks : allParks) {
            if (parks.getName().toLowerCase().contains(value.toLowerCase())) {
                results.add(parks);
//            } else if (parks.getTrail().toString().toLowerCase().contains(value.toLowerCase())) {
//                results.add(parks);
//            } else if (parks.getSkills().toString().toLowerCase().contains(value.toLowerCase())) {
//                results.add(parks);
            }
        }
        return results;
    }


}

