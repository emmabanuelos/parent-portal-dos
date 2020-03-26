package com.emmabanuelos.ParentPortal.controllers;

import com.emmabanuelos.ParentPortal.models.Parks;
import com.emmabanuelos.ParentPortal.models.ParksData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.emmabanuelos.ParentPortal.models.ParksData;

import java.util.ArrayList;
import java.util.HashMap;



    @Controller
    @RequestMapping(value = "list")
    public class ListController {

        static HashMap<String, String> columnChoices = new HashMap<>();
        static HashMap<String, Object> tableChoices = new HashMap<>();

        public ListController () {
            columnChoices.put("all", "All");
            columnChoices.put("trailName", "Trail Name");
            columnChoices.put("location", "Location");
            columnChoices.put("difficulty", "Difficulty");
            columnChoices.put("trail type", "Trail Type");
            columnChoices.put("trail distance", "Trail Distance");

            tableChoices.put("trailName", ParksData.getAllTrailNames());
            tableChoices.put("location", ParksData.getAllLocations());
            tableChoices.put("difficulty", ParksData.getAllDifficulty());
            tableChoices.put("trailType", ParksData.getAllTrailTypes());
            tableChoices.put("Distance", ParksData.getAllTrailDistances());
        }

        @RequestMapping(value = "")
        public String list(Model model) {
            model.addAttribute("columns", columnChoices);
            model.addAttribute("tableChoices", tableChoices);
            model.addAttribute("trailName", ParksData.getAllTrailName());
            model.addAttribute("locations", ParksData.getAllLocation());
            model.addAttribute("difficulty", ParksData.getAllDifficulty());
            model.addAttribute("trailType", ParksData.getAllTrailType());
            model.addAttribute("trailDistance", ParksData.getAllTrailDistance());

            return "list";
        }

        @RequestMapping(value = "parks")
        public String listParksByColumnAndValue(Model model, @RequestParam String column, @RequestParam String value) {
            ArrayList<Parks> parks;
            if (column.toLowerCase().equals("all")){
                parks = ParksData.findAll();
                model.addAttribute("title", "All Parks");
            } else {
                parks = ParksData.findByColumnAndValue(column, value);
                model.addAttribute("title", "Parks with " + columnChoices.get(column) + ": " + value);
            }
            model.addAttribute("parks", parks);

            return "list-parks";
        }
    }


