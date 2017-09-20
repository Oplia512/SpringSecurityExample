package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoRestController {

    @Autowired
    private UserService userService;

//    @RequestMapping(method = RequestMethod.POST, path = "/login")
//    public User helloRequest(@RequestBody LoginData loginData) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        User user = (User) authentication.getPrincipal();
//
//        return userService.;
//    }


    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    public String helloRequest() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User)authentication.getPrincipal();

        return "You are logged in with user: " + user.getUsername() + " and role " + user.getAuthorities().get(0);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/ignored")
    public String ignoredRequest() {
        return "Ignored";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/user")
    public List<User> getUsers() {
        return userService.findAll();
    }

}
