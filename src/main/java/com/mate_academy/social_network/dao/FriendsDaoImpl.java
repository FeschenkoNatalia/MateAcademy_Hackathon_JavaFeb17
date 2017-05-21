package com.mate_academy.social_network.dao;

import com.mate_academy.social_network.model.Friends;
import com.mate_academy.social_network.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Transactional
public class FriendsDaoImpl extends AbstractDao<Friends> implements FriendsDao {

    @Override
    public List<User> getUsersFriends(User user) {
        String hql1 = "from Friends where user1 =:user and status =:status";
        Query query1 = sessionFactory.getCurrentSession().createQuery(hql1);
        query1.setParameter("user", user);
        query1.setParameter("status", true);
        String hql2 = "from Friends where user2 =:user and status =:status";
        Query query2 = sessionFactory.getCurrentSession().createQuery(hql2);
        query2.setParameter("user", user);
        query2.setParameter("status", true);
        List<User> userList = new LinkedList<>();
        List<Friends> list1 = query1.list();
        List<Friends> list2 = query2.list();
        userList.addAll(list1.stream().map(Friends::getUser2).collect(Collectors.toList()));
        userList.addAll(list2.stream().map(Friends::getUser1).collect(Collectors.toList()));
        return userList;
    }

    @Override
    public Friends addToFriend(Long user1, Long user2) {
        //String hql = "insert "
        return null;
    }
}
