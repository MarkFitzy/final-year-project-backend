package com.jwt_macro.jwt_macroapp.service;


import com.jwt_macro.jwt_macroapp.dao.RoleDao;
import com.jwt_macro.jwt_macroapp.dao.UserDao;
import com.jwt_macro.jwt_macroapp.entity.Role;
import com.jwt_macro.jwt_macroapp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void initRoleAndUser() {

        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleDao.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Role designed for common use");
        roleDao.save(userRole);

        User adminUser = new User();
        adminUser.setUserName("MacroSocialAdmin93!");
        adminUser.setUserPassword(getEncodedPassword("MelodyAmplify23!"));
        adminUser.setUserFirstName("Macro");
        adminUser.setUserLastName("Admin");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);

    }

    public User registerNewUser(User user){
        Role role = roleDao.findById("User").get();
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        user.setRole(roleSet);
        String password = getEncodedPassword(user.getUserPassword());
        user.setUserPassword(password);
        return userDao.save(user);
    }


    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }

//    public User registerNewUser(User user) {
//        Role role = roleDao.findById("User").get();
//        Set<Role> userRoles = new HashSet<>();
//        userRoles.add(role);
//        user.setRole(userRoles);
//        user.setUserPassword(getEncodedPassword(user.getUserPassword()));
//
//        return userDao.save(user);
//    }

//    public String getEncodedPassword(String password) {
//        return passwordEncoder.encode(password);
//    }
}
