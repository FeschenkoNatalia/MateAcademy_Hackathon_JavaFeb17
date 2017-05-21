package com.mate_academy.social_network.service;

import com.mate_academy.social_network.model.Message;


public interface MessageService {

    Message getMessageById (Long id);

    Message getMessageByIdWithGroup(Long id);

    Message addMessage (Message message);
}
