package com.mate_academy.social_network.dao;

import com.mate_academy.social_network.model.User;

public interface UserDao {
    User add(User user);

    User getUser(User user);

    User getUserByName(String name);
}
