package com.mate_academy.social_network.service;

import com.mate_academy.social_network.model.Friends;
import com.mate_academy.social_network.model.User;

import java.util.List;

public interface FriendsService {

    Friends addToFriends(User user1, User user2);

    User deleteFromFriends(User user);

    List<User> getFriendsList(User user);

    Friends acceptFriend(Long currentUser, Long userForAdd);
}
