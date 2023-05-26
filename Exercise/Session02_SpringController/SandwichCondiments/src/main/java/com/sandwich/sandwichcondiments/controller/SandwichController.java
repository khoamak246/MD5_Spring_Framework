package com.sandwich.sandwichcondiments.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @GetMapping(value = "/")
    public String viewOptionSandwich() {
        return "option";
    }

    @PostMapping(value = "/save")
    public String showOption(@RequestParam String option, Model model){
        model.addAttribute("option", option);
        return "result";
    }
}
