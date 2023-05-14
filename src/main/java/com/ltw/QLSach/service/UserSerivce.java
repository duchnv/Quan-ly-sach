package com.ltw.QLSach.service;

import java.util.Optional;

import com.ltw.QLSach.model.User;

public interface UserSerivce {
    void saveUser(User user);
    boolean checkLogin(String username, String password);
    Optional<User> findById(String id);
	User findUserByid(String username);

}
