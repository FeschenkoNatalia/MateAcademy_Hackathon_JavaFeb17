package com.mate_academy.social_network.dao;

import com.mate_academy.social_network.model.Message;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class MessageDaoImpl extends AbstractDao<Message> implements MessageDao {

    @Override
    public Message getMessageByIdWithGroup(Long id) {
//        String hql = "from Message m join fetch m.group where m.id =:id";
//        Query query = sessionFactory.getCurrentSession().createQuery(hql);
//        query.setParameter("id", id);
//        return (Message) query.uniqueResult();
        return new Message();
    }

    @Override
    public List<Message> getAllMessages(Long senderId, Long recipientId) {
        String hql = "from Message m join fetch m.sender join fetch m.recipient where m.sender.id =:senderId and m.recipient.id =:recipientId";
        Query querySen = sessionFactory.getCurrentSession().createQuery(hql);
        Query queryRec = sessionFactory.getCurrentSession().createQuery(hql);
        querySen.setParameter("senderId", senderId);
        querySen.setParameter("recipientId", recipientId);
        queryRec.setParameter("senderId", recipientId);
        queryRec.setParameter("recipientId", senderId);
        List<Message> messageListSen = querySen.list();
        List<Message> messageListRec = queryRec.list();
        List<Message> result = new ArrayList<>();
        result.addAll(messageListSen);
        result.addAll(messageListRec);
        return result;
    }

    @Override
    public Long getNumberOfNotReadMessages(Long userId) {
        String hql = "Select count(m.id) from Message m where m.recipient.id =:userId and m.status = 'new'";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("userId", userId);
        return (Long) query.list().get(0);
    }


}


