package com.mate_academy.social_network.controller;


import com.mate_academy.social_network.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {

    @RequestMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("newUser", new User());
        return "registration";
    }

    public String registration(@ModelAttribute("newUser") User user, Model model) {
//        User existingUser = userService.addUser(user);
        return "home";
    }


}
