package com.mate_academy.social_network.controller;

import com.mate_academy.social_network.model.User;
import com.mate_academy.social_network.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("user", userService.getUser(new User()));
        return "home";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String home(@ModelAttribute("user") User user,
                        Model model){
        User existingUser = userService.getUser(user);
        if(existingUser != null) {
            model.addAttribute("user", existingUser);
        }
        return "home";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(@RequestParam(value = "userName", required = true) String name,
                         Model model){
        User user = userService.getUserByName(name);
        model.addAttribute("user", user);
        return "search";
    }
}
