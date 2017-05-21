package com.mate_academy.social_network.dao;

import com.mate_academy.social_network.model.Message;

public interface MessageDao extends GenericDao<Message> {

        Message getMessageByIdWithGroup(Long id);
}
