package com.emmabanuelos.ParentPortal.controllers;

import com.emmabanuelos.ParentPortal.data.ParksRepository;
import com.emmabanuelos.ParentPortal.models.Parks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("parks")
public class ParksController {

    @Autowired
    ParksRepository parksRepository;

    @GetMapping("add")
    public String displayAddEmployerForm(Model model) {
        model.addAttribute("park",new Parks());
        return "add";
    }

    @PostMapping("add")
    public String processAddParkForm(@ModelAttribute @Valid Parks newPark,
                                         Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "add";
        }
        parksRepository.save(newPark);
        return "index";
    }

}
