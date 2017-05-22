package com.mate_academy.social_network.dao;

import com.mate_academy.social_network.model.Friends;
import com.mate_academy.social_network.model.User;

import java.util.List;

public interface UserDao extends GenericDao<User>{

    List<User> getUserByName(String name);

    User getUserWithPass(User user);

    List<User> getUsersFriends(User user);

    List<User> getUsersFollowers(User user);

    List<User> getUsersSubscribers(User user);

    Friends addToFriends(Friends friends);

    Friends updateFriends(Friends friends);
}
