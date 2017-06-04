package com.project.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "types")
public class Type implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int typeId;
    private int scoreHomep;
    private int scoreAwayp;
    @ManyToOne
    @JoinColumn(name = "user")
    private User user;
    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;
    
    public Type() {
    }

    public Type(int scoreHomeTeamp, int scoreAwayTeamp) {
        this.scoreHomep = scoreHomeTeamp;
        this.scoreAwayp = scoreAwayTeamp;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getScoreHomep() {
        return scoreHomep;
    }

    public void setScoreHomep(int scoreHomeTeamp) {
        this.scoreHomep = scoreHomeTeamp;
    }

    public int getScoreAwayp() {
        return scoreAwayp;
    }

    public void setScoreAwayp(int scoreAwayTeamp) {
        this.scoreAwayp = scoreAwayTeamp;
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

    @Override
    public String toString() {
    return "Type{" + "typeId=" + typeId + ", scoreHomep=" + scoreHomep + ", scoreAwayp=" + scoreAwayp + ", user=" + user + ", game=" + game + '}';
    }
}
