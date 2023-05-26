package com.calculate.simplecalculate.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculateController {

    @GetMapping("/")
    public String showCalculateControl() {
        return "calculate";
    }

    @PostMapping("/addition")
    public String addition(@RequestParam String num1, @RequestParam String num2, Model model) {
        int numb1 = Integer.parseInt(num1);
        int numb2 = Integer.parseInt(num2);
        int result = numb1 + numb2;
        model.addAttribute("result", result);
        return "result";
    }

    @PostMapping("/subtraction")
    public String subtraction(@RequestParam String num1, @RequestParam String num2, Model model) {
        int numb1 = Integer.parseInt(num1);
        int numb2 = Integer.parseInt(num2);
        int result = numb1 - numb2;
        model.addAttribute("result", result);
        return "result";
    }

    @PostMapping("/multiplication")
    public String multiplication(@RequestParam String num1, @RequestParam String num2, Model model) {
        int numb1 = Integer.parseInt(num1);
        int numb2 = Integer.parseInt(num2);
        int result = numb1 * numb2;
        model.addAttribute("result", result);
        return "result";
    }

    @PostMapping("/division")
    public String division(@RequestParam String num1, @RequestParam String num2, Model model) {
        double numb1 = Double.parseDouble(num1);
        double numb2 = Double.parseDouble(num2);
        double result = numb1 / numb2;
        model.addAttribute("result", result);
        return "result";
    }

}
