package com.example.zent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.zent.module.GameToken;
import com.example.zent.repository.GameTokenRepo;

@Service
@Transactional
public class GameTokenService {
    private GameTokenRepo gtr;

    public GameTokenService() {
    }

    @Autowired
    public GameTokenService(GameTokenRepo gtr) {
        this.gtr = gtr;
    }

    public GameToken create(GameToken g){
        return gtr.save(g);
    }

    public GameToken authToken(GameToken g){
        return gtr.findOneByUserAndGame(g.getUser(),g.getGame());
    }


}