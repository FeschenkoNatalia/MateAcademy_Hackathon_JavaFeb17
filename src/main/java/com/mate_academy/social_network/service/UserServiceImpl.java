package com.mate_academy.social_network.service;

import com.mate_academy.social_network.dao.UserDao;
import com.mate_academy.social_network.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User addUser(User user) {
        return userDao.add(user);
    }

    @Override
    public User getUser(User user) {
        return userDao.getUser(user);
    }

    @Override
    public List<User> getUserByName(String name) {
        return userDao.getUserByName(name);
    }
}
