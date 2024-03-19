package com.darek.springsecdemo.controllers;

import com.darek.springsecdemo.model.User;
import com.darek.springsecdemo.services.UserService;
import org.hibernate.annotations.WhereJoinTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("register")
    public User register(@RequestBody User user){
        return userService.saveUser(user);
    }
}
