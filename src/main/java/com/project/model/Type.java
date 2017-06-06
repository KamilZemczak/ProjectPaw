package com.project.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "type")
public class Type implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private Integer scoreHomep;
    @Column
    private Integer scoreAwayp;
    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;
    @ManyToOne
    @JoinColumn(name = "userr_id")
    private User user;
    @Column
    private Integer points;

    public Type() {
    }

    public Type(Integer scoreHomep, Integer scoreAwayp, Game game, User user, Integer points) {
        super();
        this.scoreHomep = scoreHomep;
        this.scoreAwayp = scoreAwayp;
        this.game = game;
        this.user = user;
        this.points = points;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScoreHomep() {
        return scoreHomep;
    }

    public void setScoreHomep(Integer scoreHomep) {
        this.scoreHomep = scoreHomep;
    }

    public Integer getScoreAwayp() {
        return scoreAwayp;
    }

    public void setScoreAwayp(Integer scoreAwayp) {
        this.scoreAwayp = scoreAwayp;
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

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

}
