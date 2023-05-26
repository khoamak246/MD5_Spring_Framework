package com.medicaldeclare.form_medical_declaration.controller;


import com.medicaldeclare.form_medical_declaration.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DeclareFormController {

    @GetMapping()
    public String showFormDeclare(Model model) {
        Customer customer = new Customer();
        Vehicle vehicle = new Vehicle();
        Symptoms symptoms = new Symptoms();
        HistoryInfection historyInfection = new HistoryInfection();
        DeclareForm declare = new DeclareForm(customer, vehicle, symptoms, historyInfection);
        model.addAttribute("declareForm", declare);
        return "index";
    }

    @PostMapping("declare")
    public String setDeclare(@ModelAttribute("declareForm") DeclareForm declareForm, Model model) {
        model.addAttribute("completeForm", declareForm);
        return "info";
    }

}
