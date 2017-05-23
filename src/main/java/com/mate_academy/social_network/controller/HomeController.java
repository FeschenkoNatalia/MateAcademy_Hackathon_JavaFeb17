package com.mate_academy.social_network.controller;

import com.mate_academy.social_network.model.User;
import com.mate_academy.social_network.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String home(@CookieValue(value = "userId", required = false) Long userId,
                       Model model) {
        if (userId == null){
            return "error";
        }
        model.addAttribute("user", userService.getUser(userId));
        return "home";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String home(@ModelAttribute("user") User user,
                       @ModelAttribute("user_id") Long user_id,
                       Model model){
        User existingUser = userService.getUser(user_id);
        if(existingUser != null) {
            model.addAttribute("title", "Home");
            model.addAttribute("user", existingUser);
        }
        return "home";
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/search")
    public String search(@RequestParam(value = "username", required = true) String username,
                         Model model){
        List<User> users = userService.getUserByName(username);
        if(users != null) {
            model.addAttribute("title", "Result search");
            model.addAttribute("users", users);
            return "search";
        }
        model.addAttribute("title", "User's not found");
        model.addAttribute("message", "User is not found. Please, chrck the name.");
        return "errorMessage";
    }

    /*@RequestMapping(value = "/addfriend")
    public String addFriend(@RequestParam(value = "user") User user,
                            Model model) {
        userService.addFriend(user);
        return "home";
    }*/
}