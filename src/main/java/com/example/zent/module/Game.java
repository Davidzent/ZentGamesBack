package com.example.zent.module;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "game")
public class Game {
    @Id
    @Column(name = "gameid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gameid;

    @Column(name = "name", nullable = false, unique = false)
    private String name;

    @Column(name = "publisher", nullable = false, unique = false)
    private String publisher;

    public Game(int gameid, String name, String publisher) {
        this.gameid = gameid;
        this.name = name;
        this.publisher = publisher;
    }

    public Game() {
    }

    @Override
    public String toString() {
        return "Game [gameid=" + gameid + ", name=" + name + ", publisher=" + publisher + "]";
    }

    public int getGameid() {
        return gameid;
    }

    public void setGameid(int gameid) {
        this.gameid = gameid;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getpublisher() {
        return publisher;
    }

    public void setpublisher(String publisher) {
        this.publisher = publisher;
    }

}
