package com.jwt_macro.jwt_macroapp.entity;

import javax.persistence.*;

@Entity
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer commentId;
    private String comment;
    private String commentUsername;
    private Integer commentPostId;

    // Getters and Setters

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCommentUsername() {
        return commentUsername;
    }

    public void setCommentUsername(String commentUsername) {
        this.commentUsername = commentUsername;
    }

    public Integer getCommentPostId() {
        return commentPostId;
    }

    public void setCommentPostId(Integer commentPostId) {
        this.commentPostId = commentPostId;
    }
}