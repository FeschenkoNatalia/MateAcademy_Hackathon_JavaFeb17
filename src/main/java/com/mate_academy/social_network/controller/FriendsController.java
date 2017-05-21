package com.mate_academy.social_network.controller;

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
    public String addFriend(@RequestParam(value = "currentuser", required = true) Long user1,
                            @RequestParam(value = "user", required = true) Long user2,
                            Model model) {
        friendsService.addToFriends(userService.getUser(user1), userService.getUser(user2));
        return "friends";
    }

    @RequestMapping(value = "/accepttofriends")
    public String acceptToFriends(@RequestParam(value = "currentuser", required = true) Long currentUser,
                                  @RequestParam(value = "user", required = true) Long userForAdd,
                                  Model model){
        friendsService.acceptFriend(currentUser, userForAdd);
        return "friends";
    }
}
