package com.mate_academy.social_network.service;

import com.mate_academy.social_network.model.Friends;
import com.mate_academy.social_network.model.User;

import java.util.List;

public interface UserService {

    User addUser(User user);

    User getUser(Long id);

    User getUser(User user);

    List<User> getUserByName(String name);

    User getUserWithPass(User user);

    Friends addToFriends(User user1, User user2);

    User deleteFromFriends(User user);

    List<User> getFriendsList(User user);

    Friends acceptFriend(User user1, User user2);

    List<User> getFollowersList(User user);

    List<User> getSubscribersList(User user);
}
