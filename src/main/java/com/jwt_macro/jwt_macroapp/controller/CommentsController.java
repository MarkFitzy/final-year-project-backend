package com.jwt_macro.jwt_macroapp.controller;

import com.jwt_macro.jwt_macroapp.entity.Comments;
import com.jwt_macro.jwt_macroapp.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentsController {
    @Autowired
    private CommentsService commentService;

    @PostMapping("/addComment")
    public Comments saveComment(@RequestBody Comments comment) {
        return commentService.saveComment(comment);
    }

    @GetMapping({"/getAllComments"})
    public List<Comments> getAllComments() {
        return commentService.getAllComments();
    }

    @DeleteMapping("/deleteComment/{commentId}")
    public void deleteComment(@PathVariable Integer commentId) {
        commentService.deleteComment(commentId);
    }
}
