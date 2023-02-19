package com.jwt_macro.jwt_macroapp.dao;



import com.jwt_macro.jwt_macroapp.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User, String> {
}