package com.darek.springsecdemo.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.websocket.Session;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping
    String hello() {
        return "Hello Darek from Main";
    }

    @GetMapping("about")
    public Message about(HttpServletRequest request) {
        return new Message("This is your session id"+request.getSession().getId());
    }
}
