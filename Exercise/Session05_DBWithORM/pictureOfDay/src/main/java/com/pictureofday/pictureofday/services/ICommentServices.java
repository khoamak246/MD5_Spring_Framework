package com.pictureofday.pictureofday.services;

import com.pictureofday.pictureofday.models.Comment;

import java.util.List;

public interface ICommentServices {
    List<Comment> findAll();

    Comment findById(Long id);

    void deleteById(Long id);

    void save(Comment comment);
}
