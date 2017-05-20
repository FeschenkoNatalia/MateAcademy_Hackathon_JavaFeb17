package com.mate_academy.social_network.dao;

import com.mate_academy.social_network.model.User;

import java.util.List;

public interface UserDao {
    User add(User user);

    User getUser(User user);

    List<User> getUserByName(String name);
}
