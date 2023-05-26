package com.simpledic.simpledictionary;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class Dictionary {


    @GetMapping("/dic")
    public String dictionary(@RequestParam String word, Model model) {
        Map<String, String> dic = new HashMap<>();
        dic.put("hello", "xin chao");
        model.addAttribute("result", dic.get(word));
        return "result";
    }
}
