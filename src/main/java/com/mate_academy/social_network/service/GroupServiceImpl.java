//package com.mate_academy.social_network.service;
//
//
//import com.mate_academy.social_network.dao.GroupDao;
//import com.mate_academy.social_network.model.Group;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class GroupServiceImpl implements GroupService {
//
//    @Autowired
//    private GroupDao groupDao;
//
//    @Override
//    public Group getGroupById(Long id) {
//        return groupDao.read(Group.class, id);
//    }
//
//    @Override
//    public Group getGroupByIdWithMessages(Long id) {
//        return groupDao.getGroupByIdWithMessages(id);
//    }
//
//    @Override
//    public Group addGroup(Group group) {
//        return groupDao.create(group);
//    }
//}
