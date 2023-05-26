package com.mailsetting.mail_setting_fake.controller;


import com.mailsetting.mail_setting_fake.model.Setting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequestMapping("/")
public class SettingController {

    @GetMapping()
    public String setSetting(Model model) {
        model.addAttribute("setting", new Setting());
        return "index";
    }

    @PostMapping("setSetting")
    public String showSetting(@ModelAttribute("setting") Setting setting, Model model) {
        model.addAttribute("showSetting", setting);
        return "showSetting";
    }
}
