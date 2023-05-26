package com.convertcurrency.convertcurrency;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Convert {

    @GetMapping("/convert")
    public String showConvert(@RequestParam String money, Model model){
        int dola = Integer.parseInt(money) * 23000;
        model.addAttribute("currency", dola);
        return "convert";
    }


}
