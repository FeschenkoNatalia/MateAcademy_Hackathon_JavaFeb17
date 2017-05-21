package com.mate_academy.social_network.controller;

import com.mate_academy.social_network.model.Message;
import com.mate_academy.social_network.model.User;
import com.mate_academy.social_network.service.MessageService;
import com.mate_academy.social_network.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    @RequestMapping("/messages")
    public String showMessages(@RequestParam(value = "sender") Long senderId,
                               @RequestParam(value = "recipient") Long recipientId,
                               Model model) {

        List<Message> messageList = messageService.getAllMessages(senderId, recipientId);

        model.addAttribute("newMessage", new Message());

        User sender = userService.getUser(senderId);
        User recipient = userService.getUser(recipientId);

        model.addAttribute("messages", messageList);
        model.addAttribute("sender", sender);
        model.addAttribute("recipient", recipient);

        return "messages";
    }

    @RequestMapping(value = "/messages", method = RequestMethod.POST)
    public String showMessages(@ModelAttribute("message") Message message,
                               @ModelAttribute("sender") User sender,
                               @ModelAttribute("recipient") User recipient,
                               Model model) {

        Message mess = messageService.addMessage(message);
        if (mess != null) {
            model.addAttribute("message", mess);
        }
        return "messages";
    }

    @RequestMapping("/messages/send")
    public String sendMessage(Model model) {
        model.addAttribute("newMessage", new Message());
        return "messages";
    }

    @RequestMapping(value = "/messages/send", method = RequestMethod.POST)
    public String sendMessage(@ModelAttribute("newMessage") Message message,
                              Model model) {
        if (message != null) {
            messageService.addMessage(message);
            model.addAttribute("newMessage", message);
        }
        return "messages";
    }


}
