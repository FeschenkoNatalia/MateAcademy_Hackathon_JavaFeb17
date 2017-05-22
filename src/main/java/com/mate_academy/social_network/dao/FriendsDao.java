package com.mate_academy.social_network.dao;

import com.mate_academy.social_network.model.Friends;
import com.mate_academy.social_network.model.User;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface FriendsDao extends GenericDao<Friends> {
/*

    List<User> getUsersFriends(User user);

    List<User> getUsersFollowers(User user);

    List<User> getUsersSubscribers(User user);*/
}
