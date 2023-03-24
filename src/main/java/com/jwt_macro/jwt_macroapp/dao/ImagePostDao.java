package com.jwt_macro.jwt_macroapp.dao;

import com.jwt_macro.jwt_macroapp.entity.ImagePost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImagePostDao extends CrudRepository<ImagePost, Integer> {
    public List<ImagePost> findByUserNameContainingIgnoreCase(String userNameKey);
}
