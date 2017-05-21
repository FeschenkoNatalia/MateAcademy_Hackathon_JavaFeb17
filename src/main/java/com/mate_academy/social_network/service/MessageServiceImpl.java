package com.mate_academy.social_network.service;


import com.mate_academy.social_network.dao.MessageDao;
import com.mate_academy.social_network.model.Message;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {


    @Autowired
    private final MessageDao messageDao;

    public MessageServiceImpl(MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    @Override
    public Message getMessageById(Long id) {
        return messageDao.read(Message.class, id);
    }

    @Override
    public Message getMessageByIdWithGroup(Long id) {
        return messageDao.getMessageByIdWithGroup(id);
    }

    @Override
    public Message addMessage(Message message) {
        return messageDao.create(message);
    }

    @Override
    public List<Message> getAllMessages(Long senderId, Long recipientId) {
        return messageDao.getAllMessages(senderId, recipientId);
    }

}
