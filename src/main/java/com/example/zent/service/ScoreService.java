package com.example.zent.service;


import static com.example.zent.enums.Range.PAGESIZE;
import static com.example.zent.enums.Range.SCORES;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.zent.module.Game;
import com.example.zent.module.Score;
import com.example.zent.module.User;
import com.example.zent.repository.ScoreRepo;

@Service
@Transactional
public class ScoreService {
    private ScoreRepo sr;

    public ScoreService() {
    }

    @Autowired
    public ScoreService(ScoreRepo sr) {
        this.sr = sr;
    }

    public Score create(Score s){
        int cnt = sr.countByUserAndGame(s.getUser(),s.getGame());
        if(cnt >= SCORES.max)sr.deleteFirstByUserAndGameOrderByPointsDesc(s.getUser(), s.getGame());
            
        return sr.save(s);
    }

    public Score getGameHighScore(User u,Game g){
        return sr.findFirstByUserAndGameOrderByPointsDesc(u,g);
    }

    public List<Score> getAllScores() {
        return sr.findAll();
    }

    public List<Score> getAllUserScores(User u) {
        return sr.findByUser(u);
    }

    public List<Score> getAllUserGameScores(String u, int id){
        return sr.findAllByUserUsernameAndGameGameid(u,id);
    }

    public List<Score> getByGameScoresPaginated(int gid,int page) {
        Pageable pageable = PageRequest.of(page-1,PAGESIZE.max,Sort.by("score").descending());
        Page<Score> resultPage = sr.findAllByGameGameid(gid,pageable);
        if(resultPage.hasContent()){
            return resultPage.getContent();
        }
        return new ArrayList<>();
    }
    
}