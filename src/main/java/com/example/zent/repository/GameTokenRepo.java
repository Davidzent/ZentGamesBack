package com.example.zent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.zent.module.Game;
import com.example.zent.module.GameToken;
import com.example.zent.module.User;


@Repository
public interface GameTokenRepo extends JpaRepository<GameToken, Integer> {

    GameToken findOneByUserAndGame(User u,Game g);

}