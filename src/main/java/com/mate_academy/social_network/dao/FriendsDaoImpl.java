package com.mate_academy.social_network.dao;

import com.mate_academy.social_network.model.Friends;
import com.mate_academy.social_network.model.User;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class FriendsDaoImpl extends AbstractDao<Friends> implements FriendsDao {

    /*@Override
    public List<User> getUsersFriends(User user) {
        String hql = "from User as u where " +
                "u.id in (select f.user1 from Friends as f where f.user2=:user and status='true') " +
                "or u.id in (select f.user2 from Friends as f where f.user1=:user and status='true')";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("user", user);
        return query.list();
    }

    @Override
    public List<User> getUsersFollowers(User user) {
        String hql = "from User as u where " +
                "u.id in (select f.user1 from Friends as f where f.user2=:user and status='false')";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("user", user);
        return query.list();
    }

    @Override
    public List<User> getUsersSubscribers(User user) {
        String hql = "from User as u where " +
                "u.id in (select f.user2 from Friends as f where f.user1=:user and status='false')";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("user", user);
        return query.list();
    }*/
}