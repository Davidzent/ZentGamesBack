package com.example.zent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.zent.module.Game;
import com.example.zent.service.GameService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/game")
@CrossOrigin("http://localhost:4200")
public class GameController {
    private GameService gs;

    public GameController() {
    }

    @Autowired
    public GameController(GameService gs) {
        this.gs = gs;
    }

    @PostMapping("/create")
    @ResponseBody
    public Game createCustomer(@RequestBody Game tg, HttpSession session) {
        tg.setpublisher("ZentGames");
        return gs.create(tg);

    }

    @GetMapping("/search/?term={name}&&page={page}")
    public List<Game> getGames(@PathVariable("name") String name,@PathVariable("page") int page){
        return gs.getByNamePaginated(name, page);
    }

}