package com.spring_boot_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JV11Controller {
    @GetMapping("/jv11")
    public String jv06(){
        return "jv11";
    }
}

