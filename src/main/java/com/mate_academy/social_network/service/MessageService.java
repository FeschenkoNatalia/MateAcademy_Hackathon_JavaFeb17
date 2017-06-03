package com.mate_academy.social_network.service;

import com.mate_academy.social_network.model.Message;

import java.util.List;


public interface MessageService {

    Message getMessageById(Long id);

    Message getMessageByIdWithGroup(Long id);

    Message addMessage(Message message);

    List<Message> getAllMessages(Long senderId, Long recipientId);

    Long getNumberOfNotReadMessages(Long userId);

    Long getNumberOfNotReadMessagesFromFriend(Long recipient, Long sender);

    void markMessagesAsReadForUsers(Long senderId, Long recipientId);

    List<Message> getMessageByRecipientId(Long id);
}
