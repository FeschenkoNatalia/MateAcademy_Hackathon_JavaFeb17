package com.mate_academy.social_network.controller;

import com.mate_academy.social_network.model.Friends;
import com.mate_academy.social_network.model.User;
import com.mate_academy.social_network.service.MessageService;
import com.mate_academy.social_network.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;

    @RequestMapping("/friends")
    public String getFriendsPage(@CookieValue(value = "userId", required = false) Long userId,
                                 Model model) {
        User user = userService.getUser(userId);
        List<User> friendsList = userService.getFriendsList(user);
        model.addAttribute("friends", friendsList);
        Map<Long, Long> friendsMessagesMap = new HashMap<>();
        for (User friend : friendsList) {
            Long numberOfNotReadMessages = messageService.getNumberOfNotReadMessagesFromFriend(userId, friend.getId());
            friendsMessagesMap.put(friend.getId(), numberOfNotReadMessages);
        }
        model.addAttribute("friendsMessagesMap", friendsMessagesMap);
        return "friends";
    }

    @RequestMapping(value = "/addfriend")
    public String addFriend(@CookieValue(value = "userId", required = false) Long userId,
                            @RequestParam(value = "user", required = true) Long user2,
                            Model model) {
        Friends friend = userService.addToFriends(userService.getUser(userId), userService.getUser(user2));
        if (friend != null) {
            model.addAttribute("friends", userService.getFriendsList(userService.getUser(userId)));
            return "friends";
        }
        model.addAttribute("title", "Error");
        model.addAttribute("message", "User already exists in your friends list");
        return "errorMessage";
    }

    @RequestMapping(value = "/accepttofriends")
    public RedirectView acceptToFriends(@CookieValue(value = "userId", required = false) Long userId,
                                  @RequestParam(value = "user", required = true) Long userForAdd,
                                  Model model) {
        userService.acceptFriend(userService.getUser(userId), userService.getUser(userForAdd));
        return new RedirectView("friends");
    }

    @RequestMapping(value = "/followers")
    public String getFollowersPage(@CookieValue(value = "userId", required = false) Long userId,
                                   Model model) {
        User user = userService.getUser(userId);
        model.addAttribute("followers", userService.getFollowersList(user));
        return "followers";
    }

    @RequestMapping(value = "/subscribers")
    public String getSubscribersPage(@CookieValue(value = "userId", required = false) Long userId,
                                     Model model) {
        User user = userService.getUser(userId);
        model.addAttribute("subscribers", userService.getSubscribersList(user));
        return "subscribers";
    }

    @RequestMapping(value = "deletefromfriends")
    public RedirectView deleteFromFriends(@CookieValue(value = "userId", required = false) Long userId,
                                          @RequestParam(value = "user", required = true) Long userForAdd,
                                          Model model) {

        return new RedirectView("friends");
    }
}
