package com.mate_academy.social_network.controller;

import com.mate_academy.social_network.model.User;
import com.mate_academy.social_network.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {

    @Autowired
    private UserService userService;

    @RequestMapping("/search")
    public String search(@RequestParam(value = "userName", required = true) String name,  Model model){
        User user = userService.getUserByName(name);
        model.addAttribute("user", user);
        return "search";
    }
}
