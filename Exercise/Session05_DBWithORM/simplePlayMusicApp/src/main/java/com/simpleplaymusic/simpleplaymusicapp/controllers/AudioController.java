package com.simpleplaymusic.simpleplaymusicapp.controllers;

import com.simpleplaymusic.simpleplaymusicapp.models.Audio;
import com.simpleplaymusic.simpleplaymusicapp.services.IAudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.TypedQuery;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@PropertySource("classpath:upload_file.properties")
public class AudioController {

    @Value("${file-upload}")
    private String fileUpload;

    @Autowired
    private IAudioService audioService;

    @GetMapping("/")
    public String showIndex(Model model) {
        List<Audio> audio = audioService.findAll();
        model.addAttribute("audio", audio)
        ;
        return "index";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("audio", new Audio());
        return "create";
    }

    @PostMapping("/save")
    public String saveAudio(@ModelAttribute Audio audio, @RequestParam("url_audio") MultipartFile url_audio) {
        String url = url_audio.getOriginalFilename();
        File file = new File(fileUpload);
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            FileCopyUtils.copy(url_audio.getBytes(), new File(fileUpload + url));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        audio.setUrl(url);
        audioService.save(audio);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteAudio(@PathVariable Long id) {
        audioService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(Model model, @PathVariable Long id) {
        model.addAttribute("audio", audioService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String updateAudio(@ModelAttribute Audio audio, @RequestParam("url_audio") MultipartFile url_audio) {
        String url = url_audio.getOriginalFilename();
        Audio tempAudio = audioService.findById(audio.getId());
        if (url.length() == 0) {
            url = tempAudio.getUrl();
        } else {
            File file = new File(fileUpload + tempAudio.getUrl());
            file.delete();
        }

        audio.setUrl(url);
        audioService.save(audio);
        return "redirect:/";
    }
}
