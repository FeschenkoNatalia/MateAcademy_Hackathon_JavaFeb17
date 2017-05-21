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
        String hqlSen = "from Message where sender.id =:senderId";
        String hqlRec = "from Message where recipient.id =:recipientId";
        Query querySen = sessionFactory.getCurrentSession().createQuery(hqlSen);
        Query queryRec = sessionFactory.getCurrentSession().createQuery(hqlRec);
        querySen.setParameter("senderId", senderId);
        queryRec.setParameter("recipientId", recipientId);
        List<Message> messageListSen = querySen.list();
        List<Message> messageListRec = queryRec.list();
        List<Message> result = new ArrayList<>();
        result.addAll(messageListSen);
        result.addAll(messageListRec);
        return result;

//        String sql = "select Text from MESSAGE where sender =:senderId union select Text from MESSAGE where recipient =:recipientId";
//        Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
//        query.setParameter("senderId", senderId);
//        query.setParameter("recipientId", senderId);
////        String hql = "select Text from MESSAGE where senderId =:id union select ID from MESSAGE where recipientId =:id";
////        Query query = sessionFactory.getCurrentSession().createQuery(hql);
////        List<String> idList = query.list();
//        return  query.list();
    }


}


