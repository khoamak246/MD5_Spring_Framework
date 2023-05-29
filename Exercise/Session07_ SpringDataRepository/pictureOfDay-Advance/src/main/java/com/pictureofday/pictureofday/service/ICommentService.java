package com.pictureofday.pictureofday.service;

import com.pictureofday.pictureofday.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICommentService {
    Page<Comment> findAll(Pageable pageable);
    List<Comment> findALl();

    Comment findById(Long id);

    void deleteById(Long id);

    void save(Comment comment);
}
