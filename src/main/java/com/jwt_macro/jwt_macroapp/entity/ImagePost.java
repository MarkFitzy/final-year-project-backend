package com.jwt_macro.jwt_macroapp.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ImagePost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer postId;
    private String postCaption;
    private String postDescription;
    private String postCamera;
    private String postLens;
    private String postAperture;
    private Double postRating;
    private Double avgPostRating;

    private String postType;


    public void setUserName(User user) {
        this.userName = user.getUserName();
    }

    private String userName;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "images_post",
        joinColumns = {
            @JoinColumn(name = "post_id"),
        },
    inverseJoinColumns = {
            @JoinColumn(name = "image_id")

    })
    private Set<ImageModel> postImages;


    public Set<ImageModel> getPostImages() {
        return postImages;
    }

    public void setPostImages(Set<ImageModel> postImages) {
        this.postImages = postImages;
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getPostCaption() {
        return postCaption;
    }

    public void setPostCaption(String postCaption) {
        this.postCaption = postCaption;
    }

    public String getPostDescription() {
        return postDescription;
    }

    public void setPostDescription(String postDescription) {
        this.postDescription = postDescription;
    }

    public String getPostCamera() {
        return postCamera;
    }

    public void SetPostCamera(String postCamera) {
        this.postCamera = postCamera;
    }

    public String getPostLens() {
        return postLens;
    }

    public void SetPostLens(String postLens) {
        this.postLens = postLens;
    }
    public String getPostAperture() {
        return postAperture;
    }

    public void SetPostAperture(String postAperture) {
        this.postAperture = postAperture;
    }

    public Double getPostRating() {
        return postRating;
    }

    public void setPostRating(Double postRating) {
        this.postRating = postRating;
    }

    public Double getAvgPostRating() {
        return avgPostRating;
    }

    public void setAvgPostRating(Double avgPostRating) {
        this.avgPostRating = avgPostRating;
    }
}
