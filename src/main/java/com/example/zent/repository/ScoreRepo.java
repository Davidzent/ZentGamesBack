package com.example.zent.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.zent.module.Game;
import com.example.zent.module.Score;
import com.example.zent.module.User;

@Repository
public interface ScoreRepo extends JpaRepository<Score, Integer> {


    Score findFirstByUserAndGameOrderByScoreDesc(User u, Game g);
    Score findFirstByUserAndGameOrderByScoreAsc(User u, Game g);
    int countByUserAndGame(User user, Game game);
    void deleteFirstByUserAndGameOrderByScoreDesc(User user, Game game);
    List<Score> findAllByGameGameid(int g);
    List<Score> findByUser(User u);
    Page<Score> findAllByGameGameid(int g, Pageable pageable);
    List<Score> findAllByUserUsernameAndGameGameid(String u, int id);

}