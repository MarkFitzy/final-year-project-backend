package com.jwt_macro.jwt_macroapp.service;

import com.jwt_macro.jwt_macroapp.dao.ImagePostDao;
import com.jwt_macro.jwt_macroapp.entity.ImagePost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ImagePostService {

    @Autowired
    private ImagePostDao imagePostDao;
    public ImagePost addNewImage(ImagePost imagePost){
        return imagePostDao.save(imagePost);
    }

    public List<ImagePost> getAllPosts(String searchKey){
        if(searchKey.equals("")){
            return (List<ImagePost>)imagePostDao.findAll();

        }else {
            return imagePostDao.findByUserNameContainingIgnoreCase(searchKey);
        }

    }

    public void deletePostDetails(Integer postId) {
        imagePostDao.deleteById((postId));
    }

    public ImagePost getPostByUser(Integer postId){
        return imagePostDao.findById(postId).get();
    }

    public ImagePost getPostById(Integer postId){
        return imagePostDao.findById(postId).get();
    }


}
