package com.pictureofday.pictureofday.service;

import com.pictureofday.pictureofday.model.Comment;

import java.util.List;

public interface ICommentService {
    List<Comment> findALl();

    Comment findById(Long id);

    void deleteById(Long id);

    void save(Comment comment);
}
