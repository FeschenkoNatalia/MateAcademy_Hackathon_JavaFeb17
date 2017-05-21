//package com.mate_academy.social_network.dao;
//
//import com.mate_academy.social_network.model.Group;
//import org.hibernate.Query;
//import org.springframework.stereotype.Repository;
//
//import javax.transaction.Transactional;
//
//@Repository
//@Transactional
//public class GroupDaoImpl extends AbstractDao<Group> implements GroupDao {
//
//    public Group getGroupByIdWithMessages(Long id){
//        String hql = "from Group g join fetch g.messageList where g.id =:id";
//        Query query = sessionFactory.getCurrentSession().createQuery(hql);
//        query.setParameter("id", id);
//        return (Group) query.uniqueResult();
//    }
//}
