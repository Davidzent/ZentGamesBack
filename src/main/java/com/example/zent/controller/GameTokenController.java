package com.example.zent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.zent.service.GameTokenService;

@RestController
@RequestMapping("/game")
@CrossOrigin("http://localhost:4200")
public class GameTokenController {
    private GameTokenService gs;

    public GameTokenController() {
    }

    @Autowired
    public GameTokenController(GameTokenService gs) {
        this.gs = gs;
    }
}
