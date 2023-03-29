package com.jwt_macro.jwt_macroapp.service;

import com.jwt_macro.jwt_macroapp.dao.CommentsDao;
import com.jwt_macro.jwt_macroapp.entity.Comments;
import com.jwt_macro.jwt_macroapp.entity.ImagePost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CommentsService {

    @Autowired
    private CommentsDao commentRepository;


    public Comments saveComment(Comments comment) {
        return commentRepository.save(comment);
    }

    public List<Comments> getAllComments() {
        return (List<Comments>)commentRepository.findAll();
    }

    public void deleteComment(Integer commentId) {
        commentRepository.deleteById(commentId);
    }
}