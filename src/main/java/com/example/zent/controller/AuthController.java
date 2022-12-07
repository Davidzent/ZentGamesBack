package com.example.zent.controller;

import com.example.zent.module.User;

import jakarta.servlet.http.HttpSession;

public class AuthController {

    private AuthController() {}

    public static void setSession(User u, HttpSession session) {
        session.setAttribute("user", u);
    }

    public static User isLogin(HttpSession session) {
        Object user = session.getAttribute("user");
        if (user != null) {
            return (User) session.getAttribute("user");
        }
        return null;
    }

    public static void clearSession(HttpSession session) {
        session.invalidate();
    }
}