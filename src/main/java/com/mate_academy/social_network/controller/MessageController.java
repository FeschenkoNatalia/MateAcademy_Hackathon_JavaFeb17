package com.mate_academy.social_network.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.mate_academy.social_network.Views;
import com.mate_academy.social_network.model.AjaxResponseBody;
import com.mate_academy.social_network.model.Message;
import com.mate_academy.social_network.model.SearchCriteria;
import com.mate_academy.social_network.model.User;
import com.mate_academy.social_network.service.MessageService;
import com.mate_academy.social_network.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    @JsonView(Views.Public.class)
    @RequestMapping("/messages")
    public String showMessages(@RequestParam("recipient") Long recipientId,
                               @CookieValue(value = "userId", required = false) Long userId,
                               Model model) {
        User sender = userService.getUser(userId);
        User recipient = userService.getUser(recipientId);
        List<Message> messageList = messageService.getAllMessages(sender.getId(), recipient.getId());
        model.addAttribute("sender", sender);
        model.addAttribute("recipient", recipient);
        model.addAttribute("messages", messageList);
        model.addAttribute("newMessage", new Message());
        return "messages";
    }

    @RequestMapping(value = "/messages", method = RequestMethod.POST)
    public String sendMessage(@ModelAttribute("newMessage") Message message, Model model) {

        if (message != null) {
            messageService.addMessage(message);
            User recipient = userService.getUser(message.getRecipient().getId());
            User sender = userService.getUser(message.getSender().getId());
            List<Message> messageList = messageService.getAllMessages(sender.getId(), recipient.getId());
            model.addAttribute("recipient", recipient);
            model.addAttribute("sender", sender);
            model.addAttribute("messages", messageList);
            model.addAttribute("newMessage", new Message());
        }

        return "messages";
    }

    private List<Message> getMessagesByRecipientId(Long id) {
        return messageService.getMessageByRecipientId(id);
    }

    @ResponseBody
    @RequestMapping(value = "/messages/update", method = RequestMethod.POST)
    public AjaxResponseBody updateMessages(@RequestBody SearchCriteria searchCriteria) {
        AjaxResponseBody responseBody = new AjaxResponseBody();
        if(searchCriteria.getRecipientId() != null)
            responseBody.setResult(getMessagesByRecipientId(searchCriteria.getRecipientId()));

        return responseBody;
    }
}
