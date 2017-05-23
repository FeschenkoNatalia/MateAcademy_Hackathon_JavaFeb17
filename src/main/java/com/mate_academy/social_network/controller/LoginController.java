package com.mate_academy.social_network.controller;

import com.mate_academy.social_network.model.User;
import com.mate_academy.social_network.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        @CookieValue(value = "userId", required = false) String cookieValue,
                        Model model) {
        /*if (cookieValue!=null){
            return "home";
        }*/
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
    public RedirectView login(@ModelAttribute("user") User user, HttpServletResponse response, Model model) {
        User userFromDb = userService.getUserWithPass(user);


        if (userFromDb != null) {

            Cookie cookie = new Cookie("userId", userFromDb.getId().toString());
            cookie.setMaxAge(24 * 60 * 60);
            response.addCookie(cookie);
            return new RedirectView("/");
        }
        model.addAttribute("error", "Email and password do not match");
        return new RedirectView("login");
    }

}
