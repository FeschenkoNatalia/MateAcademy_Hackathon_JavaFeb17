package com.mate_academy.social_network.dao;

import com.mate_academy.social_network.model.Friends;
import com.mate_academy.social_network.model.User;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl extends AbstractDao<User> implements UserDao {

    @Override
    public List<User> getUserByName(String name) {
        name = name.toUpperCase();
        String hql = "from User where upper(username) =:name";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("name", name);
        return (List<User>) query.list();
    }

    @Override
    public User getUserWithPass(User user) {
        String hql = "from User where username =:username and password =:password";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("username", user.getUsername());
        query.setString("password", user.getPassword());
        return (User) query.uniqueResult();
    }

    @Override
    public List<User> getUsersFriends(User user) {
        String hql = "select b from User a join a.friends b where a.id =:userId";
        /*Criteria c = sessionFactory.getCurrentSession().createCriteria(User.class);
        c.add(Restrictions.eq("id", user.getId()));*/
        return getListFromQuery(hql, user.getId());
    }

    @Override
    public List<User> getUsersFollowers(User user) {
        String hql = "select b from User a join a.followers b where a.id =:userId";
        return getListFromQuery(hql, user.getId());
    }

    @Override
    public List<User> getUsersSubscribers(User user) {
        String hql = "select b from User a join a.subscribers b where a.id =:userId";
        return getListFromQuery(hql, user.getId());
    }

    @Override
    public Friends addToFriends(Friends friends) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.save(friends);
        } catch (Throwable ex) {
            return null;
        }
        return friends;
    }

    @Override
    public Friends updateFriends(Friends friends) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.update(friends);
        } catch (Exception ex) {
            return null;
        }
        return friends;
    }

    private List<User> getListFromQuery(String hql, Long userId) {
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("userId", userId);
        return query.list();
    }
}
