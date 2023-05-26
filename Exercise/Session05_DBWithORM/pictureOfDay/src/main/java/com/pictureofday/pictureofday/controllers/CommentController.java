package com.pictureofday.pictureofday.controllers;

import com.pictureofday.pictureofday.models.Comment;
import com.pictureofday.pictureofday.services.ICommentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class CommentController {
    @Autowired
    private ICommentServices commentServices;

    @GetMapping("/")
    public String showIndex(Model model) {
        model.addAttribute("comments", commentServices.findAll());
        return "index";
    }

    @GetMapping("/comment")
    public String showComment(Model model) {
        model.addAttribute("comment", new Comment());
        return "doComment";
    }

    @PostMapping("/doComment")
    public String doComment(@ModelAttribute Comment comment) {
        comment.setDate(LocalDate.now());
        commentServices.save(comment);
        return "redirect:/";
    }

    @PostMapping("/countLike")
    public String countLike(@RequestParam("countId") Long countId) {
        Comment comment = commentServices.findById(countId);
        comment.setLike(comment.getLike() + 1);
        commentServices.save(comment);
        return "redirect:/";
    }
}
