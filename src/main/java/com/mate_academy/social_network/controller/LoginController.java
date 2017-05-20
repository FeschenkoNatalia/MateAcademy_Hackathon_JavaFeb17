package com.mate_academy.social_network.controller;

import com.mate_academy.social_network.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Kate on 20.05.17.
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        Model model) {
        if (error != null) {
            model.addAttribute("error", "Email and password do not match");
        }
        if (logout != null) {
            model.addAttribute("logout", "You have been logged out successfully");
        }
        model.addAttribute("user", new User());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("user") User user, Model model) {
        //add code

        return "login";
    }
}
