package com.pyotr.userservice.service;

import com.pyotr.userservice.domain.Role;
import com.pyotr.userservice.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String rolename);
    User getUser(String username);
    List<User>getUsers();
}
