package com.mate_academy.social_network.service;

import com.mate_academy.social_network.dao.FriendsDao;
import com.mate_academy.social_network.model.Friends;
import com.mate_academy.social_network.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendsServiceImpl implements FriendsService {

    /*@Autowired
    public FriendsDao friendsDao;

    @Override
    public Friends addToFriends(User user1, User user2) {
        Friends friends = new Friends();
        friends.setUser1(user1);
        friends.setUser2(user2);
        friends.setStatus(false);
        try {
            friends = friendsDao.create(friends);
        } catch (Exception e) {
            return null;
        }
        return friends;
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
    public Friends acceptFriend(User user1, User user2) {
        Friends friends = new Friends();
        friends.setUser1(user1);
        friends.setUser2(user2);
        friends.setStatus(true);
        return friendsDao.update(friends);
    }

    @Override
    public List<User> getFollowersList(User user) {
        return friendsDao.getUsersFollowers(user);
    }

    @Override
    public List<User> getSubscribersList(User user) {
        return friendsDao.getUsersSubscribers(user);
    }*/
}
