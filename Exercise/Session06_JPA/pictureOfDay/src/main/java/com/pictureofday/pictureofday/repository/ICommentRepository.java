package com.pictureofday.pictureofday.repository;

import com.pictureofday.pictureofday.model.Comment;

import java.util.List;

public interface ICommentRepository {
    List<Comment> findALl();

    Comment findById(Long id);

    void deleteById(Long id);

    void save(Comment comment);
}
