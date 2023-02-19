package com.jwt_macro.jwt_macroapp.dao;



import com.jwt_macro.jwt_macroapp.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends CrudRepository<Role, String> {

}
