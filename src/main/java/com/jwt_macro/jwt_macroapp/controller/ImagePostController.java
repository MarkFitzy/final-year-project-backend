package com.jwt_macro.jwt_macroapp.controller;

import com.jwt_macro.jwt_macroapp.entity.ImageModel;
import com.jwt_macro.jwt_macroapp.entity.ImagePost;
import com.jwt_macro.jwt_macroapp.service.ImagePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class ImagePostController {


    @Autowired
    private ImagePostService imagePostService;
    @PostMapping(value = {"/addNewImage"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ImagePost addNewImage(@RequestPart("imagePost") ImagePost imagePost,
                                 @RequestPart("imageFile")MultipartFile[] file){
        try {
            Set<ImageModel> images = uploadImage(file);
            imagePost.setPostImages(images);
            return imagePostService.addNewImage(imagePost);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    public Set<ImageModel> uploadImage(MultipartFile[] multipartFiles) throws IOException {
        Set<ImageModel> imageModels = new HashSet<>();
        for (MultipartFile file : multipartFiles){
            ImageModel imageModel = new ImageModel(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()
            );
            imageModels.add(imageModel);
        }
        return imageModels;
    }

    @GetMapping({"/getAllPosts"})
    public List<ImagePost> getAllPosts(){
        return imagePostService.getAllPosts();
    }

    @GetMapping({"getPostById/{postId}"})
    public ImagePost getPostById(@PathVariable("postId") Integer postId) {
        return imagePostService.getPostById(postId);
    }

    @DeleteMapping({"/deletePostDetails/{postId}"})
    public void deletePostDetails(@PathVariable("postId") Integer postId) {

        imagePostService.deletePostDetails(postId);

    }
}
