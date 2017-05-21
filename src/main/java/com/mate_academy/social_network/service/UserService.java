package com.mate_academy.social_network.service;

import com.mate_academy.social_network.model.User;

import java.util.List;

public interface UserService {

    User addUser(User user);

    User getUser(Long id);

    User getUser(User user);

    List<User> getUserByName(String name);
}
