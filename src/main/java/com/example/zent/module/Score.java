package com.example.zent.module;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "score")
public class Score {
    @Id
    @Column(name = "scoreid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int scoreid;

    @Column(name = "score", nullable = false)
    private int points;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Game game;

    public Score(int scoreid, int points, User user, Game game) {
        this.scoreid = scoreid;
        this.points = points;
        this.user = user;
        this.game = game;
    }

    public Score() {
    }

    @Override
    public String toString() {
        return "Score [scoreid=" + scoreid + ", points=" + points + ", user=" + user + ", game=" + game + "]";
    }

    public int getScoreid() {
        return scoreid;
    }

    public void setScoreid(int scoreid) {
        this.scoreid = scoreid;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    


}