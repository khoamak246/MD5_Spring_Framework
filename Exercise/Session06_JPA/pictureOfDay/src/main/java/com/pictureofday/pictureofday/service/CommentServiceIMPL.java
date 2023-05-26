package com.pictureofday.pictureofday.service;

import com.pictureofday.pictureofday.model.Comment;
import com.pictureofday.pictureofday.repository.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceIMPL implements ICommentService{

    @Autowired
    private ICommentRepository commentRepository;


    @Override
    public List<Comment> findALl() {
        return commentRepository.findALl();
    }

    @Override
    public Comment findById(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }
}
