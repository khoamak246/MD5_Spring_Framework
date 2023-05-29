package com.songinfovalidate.controller;

import com.songinfovalidate.model.SongInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;


@Controller
public class SongController {

    @GetMapping("/")
    public String showIndex(Model model) {
        model.addAttribute("song", new SongInfo());
        return "index";
    }

    @PostMapping("/add-song")
    public String addSong(@Valid @ModelAttribute("song") SongInfo songInfo,
                          BindingResult result,
                          Model model) {
        new SongInfo().validate(songInfo, result);
        if (result.hasFieldErrors()) {
            return "index";
        }
        model.addAttribute("song", songInfo);
        return "result";

    }

}
