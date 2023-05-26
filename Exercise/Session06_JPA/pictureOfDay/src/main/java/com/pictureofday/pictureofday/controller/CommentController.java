package com.pictureofday.pictureofday.controller;


import com.pictureofday.pictureofday.model.Comment;
import com.pictureofday.pictureofday.service.ICommentService;
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
    private ICommentService commentService;

    @GetMapping("/")
    public String showIndex(Model model) {
        model.addAttribute("comments", commentService.findALl());
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
        commentService.save(comment);
        return "redirect:/";
    }

    @PostMapping("/countLike")
    public String countLike(@RequestParam("countId") Long countId) {
        Comment comment = commentService.findById(countId);
        comment.setFavorite(comment.getFavorite() + 1);
        commentService.save(comment);
        return "redirect:/";
    }

}
