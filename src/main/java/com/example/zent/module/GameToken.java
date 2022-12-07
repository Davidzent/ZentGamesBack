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
@Table(name = "gametoken")
public class GameToken {
    @Id
    @Column(name = "tokenid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tokenid;

    @Column(name = "token", nullable = false)
    private String token;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Game game;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private User user;

    public GameToken(int tokenid, String token, Game game, User user) {
        this.tokenid = tokenid;
        this.token = token;
        this.game = game;
        this.user = user;
    }

    public GameToken() {
    }

    @Override
    public String toString() {
        return "token [tokenid=" + tokenid + ", token=" + token + ", game=" + game + ", user=" + user + "]";
    }

    public int getTokenid() {
        return tokenid;
    }

    public void setTokenid(int tokenid) {
        this.tokenid = tokenid;
    }

    public String gettoken() {
        return token;
    }

    public void settoken(String token) {
        this.token = token;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
