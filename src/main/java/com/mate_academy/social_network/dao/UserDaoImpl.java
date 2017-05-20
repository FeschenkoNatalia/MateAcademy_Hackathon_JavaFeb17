package com.mate_academy.social_network.dao;

import com.mate_academy.social_network.model.User;
import com.mate_academy.social_network.service.UserService;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    protected SessionFactory sessionFactory;

    @Override
    public User add(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
        session.flush();
        return user;
    }

    @Override
    public User getUser(User user) {
        String hql = "from User where username = :name and password = :password";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("name", user.getUsername());
        query.setString("password", user.getPassword());
        return (User) query.uniqueResult();
    }

    @Override
    public List<User> getUserByName(String name) {
        name = name.toUpperCase();
        String hql = "from User where upper(username) =:name";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("name", name);
        return (List<User>) query.list();
    }
}
