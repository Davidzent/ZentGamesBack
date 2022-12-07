package com.example.zent.controller;

import static com.example.zent.controller.AuthController.isLogin;

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

import com.example.zent.module.Score;
import com.example.zent.module.User;
import com.example.zent.service.ScoreService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/score")
@CrossOrigin("http://localhost:4200")
public class ScoreController {

    private ScoreService ss;

    public ScoreController() {
    }

    @Autowired
    public ScoreController(ScoreService ss) {
        this.ss = ss;
    }

    @GetMapping("/")
    public List<Score> getAllScores() {
        return ss.getAllScores();
    }

    @PostMapping("/create")
    @ResponseBody
    public Score createCustomer(@RequestBody Score s, HttpSession session) {
        return ss.create(s);

    }

    @GetMapping("/user")
    public List<Score> getUserScores(HttpSession session) {
        User u = isLogin(session);
        return ss.getAllUserScores(u);
    }

    @GetMapping("/{user}/{game}")
    public List<Score> getUserGameScores(@PathVariable("user") String user,@PathVariable("id") int gid) {
        return ss.getAllUserGameScores(user,gid);
    }

    @GetMapping("/game/{game}/{page}")
    public List<Score> getGameScores(@PathVariable("id") int gid,@PathVariable("page") int page) {
        return ss.getByGameScoresPaginated(gid, page);
    }



}