package com.registerformvalidate.controller;

import com.registerformvalidate.model.User;
import com.registerformvalidate.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/")
    public String showIndex(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("/register")
    public String doRegister(@Validated @ModelAttribute User user, BindingResult result, Model model) {
        if (result.hasFieldErrors()) {
            return "index";
        }
        model.addAttribute("user", userService.save(user));
        return "result";
    }


}
