package com.mate_academy.social_network.dao;

import com.mate_academy.social_network.model.Message;

import java.util.List;

public interface MessageDao extends GenericDao<Message> {

        public Message getMessageByIdWithGroup(Long id);

        public List<Message> getAllMessages(Long sender_id, Long recipient_id);
}
