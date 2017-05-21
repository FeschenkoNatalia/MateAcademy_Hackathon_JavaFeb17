package com.mate_academy.social_network.service;

import com.mate_academy.social_network.dao.FriendsDao;
import com.mate_academy.social_network.model.Friends;
import com.mate_academy.social_network.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendsServiceImpl implements FriendsService {

    @Autowired
    public FriendsDao friendsDao;

    @Override
    public Friends addToFriends(User user1, User user2) {
        Friends friends = new Friends();
        friends.setStatus(false);
        friends.setUser1(user1);
        friends.setUser2(user2);
        return friendsDao.create(friends);
    }

    @Override
    public User deleteFromFriends(User user) {
        return null;
    }

    @Override
    public List<User> getFriendsList(User user) {
        return friendsDao.getUsersFriends(user);
    }

    @Override
    public Friends acceptFriend(Long currentUser, Long userForAdd) {
        return friendsDao.addToFriend(currentUser, userForAdd);
    }
}
