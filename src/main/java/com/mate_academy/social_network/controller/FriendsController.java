package com.mate_academy.social_network.controller;

import com.mate_academy.social_network.model.Friends;
import com.mate_academy.social_network.model.User;
import com.mate_academy.social_network.service.FriendsService;
import com.mate_academy.social_network.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

@Controller
public class FriendsController {

    @Autowired
    private FriendsService friendsService;

    @Autowired
    private UserService userService;

    @RequestMapping("/friends")
    public String getFriendsPage(@CookieValue(value = "userId", required = false) Long userId,
                                 Model model) {
        User user = userService.getUser(userId);
        model.addAttribute("friends", friendsService.getFriendsList(user));
        return "friends";
    }

    @RequestMapping(value = "/addfriend")
    public String addFriend(@CookieValue(value = "userId", required = false) Long userId,
                            @RequestParam(value = "user", required = true) Long user2,
                            Model model) {
        Friends friend = friendsService.addToFriends(userService.getUser(userId), userService.getUser(user2));
        if(friend != null) {
            model.addAttribute("friends", friendsService.getFriendsList(userService.getUser(userId)));
            return "friends";
        }
        model.addAttribute("title", "Error");
        model.addAttribute("message", "User already exists in your friends list");
        return "errorMessage";
    }

    @RequestMapping(value = "/accepttofriends")
    public String acceptToFriends(@CookieValue(value = "userId", required = false) Long userId,
                                  @RequestParam(value = "user", required = true) Long userForAdd,
                                  Model model){
        friendsService.acceptFriend(userService.getUser(userId), userService.getUser(userForAdd));
        model.addAttribute("friends", friendsService.getFriendsList(userService.getUser(userId)));
        return "friends";
    }
}
