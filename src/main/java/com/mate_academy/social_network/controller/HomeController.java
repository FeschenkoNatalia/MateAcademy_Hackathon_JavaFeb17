package com.mate_academy.social_network.controller;

import com.mate_academy.social_network.model.User;
import com.mate_academy.social_network.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    private UserService userService;

    @RequestMapping("home")
    public String home(Model model) {
       // model.addAttribute("user", userService.getUser());
        return "home";
    }

    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public String home(@RequestParam(value = "logout", required = false) String logout,
                        Model model){
        /*User user = userService.getUser();
        if(user != null) {
            model.addAttribute("user", user);
        }*/
        return "home";
    }


}
