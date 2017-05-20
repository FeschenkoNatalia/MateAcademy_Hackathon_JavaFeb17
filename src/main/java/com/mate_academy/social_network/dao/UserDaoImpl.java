package com.mate_academy.social_network.dao;

import com.mate_academy.social_network.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDaoImpl implements UserDao {

    @Autowired
    protected SessionFactory sessionFactory;

    @Override
    public User add(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
        session.flush();
        return null;
    }

    @Override
    public User getUser(User user) {
        String hql = "from User where username = :name and password = :password";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("name", user.getUsername());
        query.setString("password", user.getPassword());
        return (User) query.uniqueResult();
    }
}
