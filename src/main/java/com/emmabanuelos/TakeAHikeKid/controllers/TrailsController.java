package com.emmabanuelos.TakeAHikeKid.controllers;

import com.emmabanuelos.TakeAHikeKid.data.TrailRepository;
import com.emmabanuelos.TakeAHikeKid.models.Trail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

public class TrailsController {

    @Autowired
    TrailRepository trailRepository;

    @GetMapping("add")
    public String displayAddTrailForm(Model model) {
        model.addAttribute("trail",new Trail());
        return "add";
    }

    @PostMapping("add")
    public String processAddTrailForm(@ModelAttribute @Valid Trail newTrail,
                                     Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "add";
        }
        trailRepository.save(newTrail);
        return "index";
    }

}
