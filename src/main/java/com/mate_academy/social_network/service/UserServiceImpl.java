package com.mate_academy.social_network.service;

import com.mate_academy.social_network.dao.UserDao;
import com.mate_academy.social_network.model.Friends;
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
    public User getUser(Long id) {
        return userDao.read(User.class, id);
    }

    @Override
    public User getUser(User user) {
        return userDao.read(user);
    }

    @Override
    public User addUser(User user) {
        return user;
    }

    @Override
    public List<User> getUserByName(String name) {
        return userDao.getUserByName(name);
    }

    @Override
    public User getUserWithPass(User user) {
        return userDao.getUserWithPass(user);
    }

    @Override
    public Friends addToFriends(User user1, User user2) {
        Friends friends = new Friends();
        friends.setUser1(user1);
        friends.setUser2(user2);
        friends.setStatus(false);
        return userDao.addToFriends(friends);
    }

    @Override
    public User deleteFromFriends(User user) {
        return null;
    }

    @Override
    public List<User> getFriendsList(User user) {
        return userDao.getUsersFriends(user);
    }

    @Override
    public Friends acceptFriend(User user1, User user2) {
        Friends friends = new Friends();
        friends.setUser1(user1);
        friends.setUser2(user2);
        friends.setStatus(true);
        return userDao.updateFriends(friends);
    }

    @Override
    public List<User> getFollowersList(User user) {
        return userDao.getUsersFollowers(user);
    }

    @Override
    public List<User> getSubscribersList(User user) {
        return userDao.getUsersSubscribers(user);
    }
}
