package com.emmabanuelos.ParentPortal.controllers;

import com.emmabanuelos.ParentPortal.models.Parks;
import com.emmabanuelos.ParentPortal.models.ParksData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;

import static com.emmabanuelos.ParentPortal.controllers.ListController.columnChoices;

@Controller
@RequestMapping("search")

public class SearchController {

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }

    // TODO #3 - Create a handler to process a search request and render the updated search view.
    @RequestMapping(value = "results")
    public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm) {
//        model.addAttribute("SearchType", searchType);
//        model.addAttribute("SearchTerm", searchTerm);
        //the arraylist needs to be put into the code first because the results needs to have a place to go before they into the array
        ArrayList<Parks> parks = new ArrayList<>();

        if (searchTerm.toLowerCase().equals("all")) {
            parks = ParksData.findAll();
            model.addAttribute("title", "All Parks");

        }else {
            parks = ParksData.findByColumnAndValue(searchType, searchTerm);
            model.addAttribute("title", "Parks with " + columnChoices.get(searchType + ": " + searchTerm));
        }
        model.addAttribute("columns", columnChoices);
        model.addAttribute("parks", parks);

        return "search";
    }


}

