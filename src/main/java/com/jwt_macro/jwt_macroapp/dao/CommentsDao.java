package com.jwt_macro.jwt_macroapp.dao;

import com.jwt_macro.jwt_macroapp.entity.Comments;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CommentsDao extends CrudRepository<Comments, Integer> {
}
