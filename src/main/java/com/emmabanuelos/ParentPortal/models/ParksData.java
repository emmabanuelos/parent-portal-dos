package com.emmabanuelos.ParentPortal.models;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import com.emmabanuelos.ParentPortal.NameSorter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

    public class ParksData {


        private static final String DATA_FILE = "stlouis_hikes_data.csv";
        private static boolean isDataLoaded = false;

        private static ArrayList<Parks> allParks;
        private static ArrayList<TrailName> allTrailName = new ArrayList<>();
        private static ArrayList<Location> allLocations = new ArrayList<>();
        private static ArrayList<Difficulty> allDifficulty = new ArrayList<>();
        private static ArrayList<TrailType> allTrailType = new ArrayList<>();
        private static ArrayList<TrailDistance> allTrailDistance = new ArrayList<>();


        /**
         * Fetch list of all job objects from loaded data,
         * without duplicates, then return a copy.
         */

        public static ArrayList<Parks> findAll() {

            // load data, if not already loaded
            loadData();

            // Bonus mission; normal version returns allJobs
            return new ArrayList<>(allParks);
        }

        /**
         * Notes from Tech Jobs code---
         * Returns the results of searching the Jobs data by field and search term.
         * <p>
         * For example, searching for employer "Enterprise" will include results
         * with "Enterprise Holdings, Inc".
         *
         * @param column Job field that should be searched.
         * @param value  Value of the field to search for.
         * @return List of all jobs matching the criteria.
         */
        public static ArrayList<Parks> findByColumnAndValue(String column, String value) {

            // load data, if not already loaded
            loadData();

            ArrayList<Parks> parks = new ArrayList<>();

            if (value.toLowerCase().equals("all")) {
                return findAll();
            }

            if (column.equals("all")) {
                parks = findByValue(value);
                return parks;
            }
            for (Parks park : allParks) {

                String aValue = getFieldValue(park, column);

                if (aValue != null && aValue.toLowerCase().contains(value.toLowerCase())) {
                    parks.add(park);
                }
            }

            return parks;
        }

        public static String getFieldValue(Parks parks, String fieldName) {
            String theValue = "";
            if (fieldName.equals("name")) {
                theValue = parks.getName();
            } else if (fieldName.equals("trail name")) {
                theValue = parks.getTrailName().toString();
            } else if (fieldName.equals("location")) {
                theValue = parks.getLocation().toString();
            } else if (fieldName.equals("difficulty")) {
                theValue = parks.getDifficulty().toString();
            } else if (fieldName.equals("trail distance")) {
                theValue = parks.getTrailDistance().toString();

            } else if (fieldName.equals("trail type")){
                theValue = parks.getTrailType().toString();
            }

            return theValue;
        }

        /**
         * Search all Job fields for the given term.
         *
         * @param value The search term to look for.
         * @return List of all jobs with at least one field containing the value.
         */
        public static <CSVParser, CSVRecord> Object findByValue(String value) {

            // load data, if not already loaded
            loadData();

            ArrayList<Parks> park= new ArrayList<>();

            for (Parks parks : allParks) {

                if (parks.getName().toLowerCase().contains(value.toLowerCase())) {
                    park.add(parks);
                } else if (parks.getTrailName().toString().toLowerCase().contains(value.toLowerCase())) {
                    park.add(parks);
                } else if (parks.getLocation().toString().toLowerCase().contains(value.toLowerCase())) {
                    park.add(parks);
                } else if (parks.getDifficulty().toString().toLowerCase().contains(value.toLowerCase())) {
                    park.add(parks);
                } else if (parks.getTrailType().toString().toLowerCase().contains(value.toLowerCase())) {
                    park.add(parks);
                } else if (parks.getTrailDistance().toString().toLowerCase().contains(value.toLowerCase())) {
                    park.add(parks);

                }

                return park;
            }

            private static Object findExistingObject (ArrayList list, String value){
                for (Object item : list) {
                    if (item.toString().toLowerCase().equals(value.toLowerCase())) {
                        return item;
                    }
                }
                return null;
            }

            /**
             * Read in data from a CSV file and store it in an ArrayList of Job objects.
             */
            private static void loadData () {

                // Only load data once
                if (isDataLoaded) {
                    return;
                }

                try {

                    // Open the CSV file and set up pull out column header info and records
                    Resource resource = new ClassPathResource(DATA_FILE);
                    InputStream is = resource.getInputStream();
                    Reader reader = new InputStreamReader(is);
                    CSVParser parser = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(reader);
                    List<CSVRecord> records = parser.getRecords();
                    Integer numberOfColumns = records.get(0).size();
                    String[] headers = parser.getHeaderMap().keySet().toArray(new String[numberOfColumns]);

                    allParks = new ArrayList<>();

                    // Put the records into a more friendly format
                    for (CSVRecord record : records) {

                        String aName = record.get(0);
                        String aTrailName = record.get(1);
                        String aLocation = record.get(2);
                        String aDifficulty = record.get(3);
                        String aTrailType = record.get(4);
                        String aTrailDistance = record.get(5);

                        TrailName newTrailName = (TrailName) findExistingObject(allTrailName, aTrailName);
                        Location newLocation = (Location) findExistingObject(allLocations, aLocation);
                        Difficulty newDifficulty = (Difficulty) findExistingObject(allDifficulty, aDifficulty);
                        TrailType newTrailType = (TrailType) findExistingObject(allTrailType, aTrailType);
                        TrailDistance newTrailDistance = (TrailDistance) findExistingObject(allTrailDistance, aTrailDistance);

                        if (newTrailName == null) {
                            newTrailName = new TrailName(aTrailName);
                            allTrailName.add(newTrailName);
                        }

                        if (newLocation == null) {
                            newLocation = new Location(aLocation);
                            allLocations.add(newLocation);
                        }

                        if (newDifficulty == null) {
                            newDifficulty = new Difficulty(aDifficulty);
                            allDifficulty.add(newDifficulty);
                        }

                        if (newTrailType == null) {
                            newTrailType = new TrailType(aTrailType);
                            allTrailType.add(newTrailType);
                        }

                        if (newTrailDistance == null) {
                            newTrailDistance = new TrailDistance(aTrailDistance);
                            allTrailDistance.add(newTrailDistance);
                        }

                        Parks newPark = new Parks(aName, newTrailName, newLocation, newDifficulty, newTrailType, newTrailDistance);

                        allParks.add(newPark);
                    }
                    // flag the data as loaded, so we don't do it twice
                    isDataLoaded = true;

                } catch (IOException e) {
                    System.out.println("Failed to load job data");
                    e.printStackTrace();
                }
            }

            public static ArrayList<TrailName> getAllTrailName () {
                loadData();
                allTrailName.sort(new NameSorter());
                return allTrailName;
            }

            public static ArrayList<Location> getAllLocation() {
                loadData();
                allLocations.sort(new NameSorter());
                return allLocations;
            }

            public static ArrayList<Difficulty> getAllDifficulty() {
                loadData();
                allDifficulty.sort(new NameSorter());
                return allDifficulty;
            }

            public static ArrayList<TrailType> getAllTrailType() {
                loadData();
                allTrailType.sort(new NameSorter());
                return allTrailType;
            }

            public static ArrayList<TrailDistance> getAllTrailDistance() {
                loadData();
                allTrailDistance.sort(new NameSorter());
                return allTrailDistance;
            }

        }

//        private static Object findExistingObject(ArrayList<TrailName> allTrailName, String aTrailName) {
//        }


    }