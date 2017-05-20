package com.mate_academy.social_network.dao;

import com.mate_academy.social_network.model.Message;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class MessageDaoImpl extends AbstractDao<Message> implements MessageDao {

    @Override
    public Message getMessageByIdWithGroup(Long id) {
            String hql = "from Message m join fetch m.group where m.id =:id";
            Query query = sessionFactory.getCurrentSession().createQuery(hql);
            query.setParameter("id", id);
            return (Message) query.uniqueResult();
        }
    }
