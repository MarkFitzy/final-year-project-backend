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
    private String userFirstName;
    private String userLastName;
    private String userName;

    private String postType;



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

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}