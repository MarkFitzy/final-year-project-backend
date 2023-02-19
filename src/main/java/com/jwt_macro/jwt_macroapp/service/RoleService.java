package com.jwt_macro.jwt_macroapp.service;


import com.jwt_macro.jwt_macroapp.dao.RoleDao;
import com.jwt_macro.jwt_macroapp.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    public Role createNewRole(Role role) {
        return roleDao.save(role);
    }
}