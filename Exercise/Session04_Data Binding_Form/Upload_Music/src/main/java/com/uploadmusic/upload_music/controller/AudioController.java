package com.uploadmusic.upload_music.controller;


import com.uploadmusic.upload_music.model.Audio;
import com.uploadmusic.upload_music.model.AudioForm;
import com.uploadmusic.upload_music.service.AudioServiceIMPL;
import com.uploadmusic.upload_music.service.IAudioService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/audio")
@PropertySource("classpath:upload_file.properties")
public class AudioController {
    private final IAudioService serviceIMPL = new AudioServiceIMPL();

    @Value("${file-upload}")
    private String fileUpload;

    @GetMapping("")
    public String index(Model model) {
        List<Audio> audios = serviceIMPL.findAll();
        model.addAttribute("audios", audios);
        return "/index";
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("audioForm", new AudioForm());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveProduct(@ModelAttribute AudioForm audioForm) {
        MultipartFile multipartFile = audioForm.getUrl();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(audioForm.getUrl().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Audio audio = new Audio(audioForm.getId(), audioForm.getName(), audioForm.getDescription(), fileName);
        serviceIMPL.save(audio);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("audioForm", audioForm);
        modelAndView.addObject("message", "Created new audio successfully !");
        return modelAndView;
    }
}
