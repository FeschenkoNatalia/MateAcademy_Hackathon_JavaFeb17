package com.mate_academy.social_network.controller;

import com.mate_academy.social_network.service.GroupService;
import com.mate_academy.social_network.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private GroupService groupService;


}
