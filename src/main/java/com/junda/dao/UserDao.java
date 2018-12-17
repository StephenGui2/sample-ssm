package com.junda.dao;

import com.junda.model.User;

import java.util.List;

public interface UserDao {

    User findByUserId(Long userId);

    List<User> getUserList();

    int deleteByUserId(Long userId);

    int update(User user);

    int add(User user);

}
