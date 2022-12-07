package com.example.zent.controller;

import static com.example.zent.controller.AuthController.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.zent.module.User;
import com.example.zent.service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin("http://localhost:4200")
public class UserController {
    private UserService us;

    public UserController() {}

    @Autowired
    public UserController(UserService us) {
        this.us = us;
    }

    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<User> createUser(@RequestBody User p, HttpSession session) {
        User e = us.getProfileByEmail(p);
        if (e != null) return new ResponseEntity<>(HttpStatus.IM_USED);
        User u = us.register(p);
        setSession(u, session);
        return new ResponseEntity<>(u, HttpStatus.CREATED); 
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User p, HttpSession session) {
        User u = us.login(p);
        setSession(u, session);
        return new ResponseEntity<>(u, HttpStatus.CREATED);
    }

    @PostMapping("/logout")
    public void logout(HttpSession session) {
        clearSession(session);
    }

    @GetMapping("/islogin")
    public ResponseEntity<User> isloged(HttpSession session) {
        return new ResponseEntity<>(isLogin(session), HttpStatus.ACCEPTED);
    }

    @PutMapping("/update")
    public ResponseEntity<User> update(@RequestBody User u, HttpSession session) {
        User p = isLogin(session);
        u.setUserid(p.getUserid());
        return new ResponseEntity<>(us.update(u), HttpStatus.ACCEPTED);
    }
}