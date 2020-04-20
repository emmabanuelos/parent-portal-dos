package com.emmabanuelos.ParentPortal.controllers;

import com.emmabanuelos.ParentPortal.data.ParksData;
import com.emmabanuelos.ParentPortal.data.ParksRepository;
import com.emmabanuelos.ParentPortal.data.TrailRepository;
import com.emmabanuelos.ParentPortal.models.Parks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

public class ListController {
    @Autowired
    private ParksRepository parksRepository;

    @Autowired
    private TrailRepository trailRepository;

//    @Autowired
//    private SkillRepository skillRepository;

    static HashMap<String, String> columnChoices = new HashMap<>();

    public ListController () {

        columnChoices.put("all", "All");
        columnChoices.put("parks", "Parks");
        columnChoices.put("trail", "Trail");

    }

    @RequestMapping("")
    public String list(Model model) {
        model.addAttribute("parks", parksRepository.findAll());
        model.addAttribute("trail", trailRepository.findAll());
        return "list";
    }

    @RequestMapping(value = "parks")
    public String listJobsByColumnAndValue(Model model, @RequestParam String column, @RequestParam String value) {
        Iterable<Parks> parks;
        if (column.toLowerCase().equals("all")){
            parks = parksRepository.findAll();
            model.addAttribute("title", "All Jobs");
        } else {
            parks = ParksData.findByColumnAndValue(column, value, parksRepository.findAll());
            model.addAttribute("title", "Parks to go " + columnChoices.get(column) + ": " + value);
        }
        model.addAttribute("parks", parks);

        return "list-parks";
    }
}


