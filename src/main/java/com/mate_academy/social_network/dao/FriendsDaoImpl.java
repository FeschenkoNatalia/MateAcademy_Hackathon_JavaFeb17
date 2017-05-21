package com.mate_academy.social_network.dao;

import com.mate_academy.social_network.model.Friends;
import com.mate_academy.social_network.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class FriendsDaoImpl extends AbstractDao<Friends> implements FriendsDao {

    @Override
    public List<Friends> getUsersFriends(User user) {
        String hql1 = "from Friends where user1 =:user and status =:status";
        Query query1 = sessionFactory.getCurrentSession().createQuery(hql1);
        query1.setParameter("user", user);
        query1.setParameter("status", true);
        String hql2 = "from Friends where user2 =:user and status =:status";
        Query query2 = sessionFactory.getCurrentSession().createQuery(hql2);
        query2.setParameter("user", user);
        query2.setParameter("status", true);
        List<Friends> list = query1.list();
        list.add((Friends) query2.list());
        return list;
    }
}
