package com.mate_academy.social_network.controller;

import com.mate_academy.social_network.model.Message;
import com.mate_academy.social_network.model.User;
import com.mate_academy.social_network.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MessageController {

    @Autowired
    private MessageService messageService;

//    @Autowired
//    private GroupService groupService;

    @RequestMapping(value = "/message", method = RequestMethod.POST)
    public String registration(@ModelAttribute("message")Message message, Model model) {
        Message mess = messageService.addMessage(message);
        if (mess != null) {
            model.addAttribute("message", mess);
        }
        return "message";
    }
}
