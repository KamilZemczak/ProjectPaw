package com.project.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity; 
import javax.persistence.GeneratedValue; 
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="game")
public class Game implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private Integer round;
    @Column
    private Integer scoreHomea;
    @Column
    private Integer scoreAwaya;
    @Column
    private String homeTeam;
    @Column
    private String awayTeam;
    @Column
    private String dateGame;
    @Column
    private boolean finished;
      
    public Game() {
    }

    public Game(String homeTeam, String awayTeam, String dateGame, boolean finished) {
        super();
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.dateGame = dateGame;
        this.finished = finished;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRound() {
        return round;
    }

    public void setRound(Integer round) {
        this.round = round;
    }

    public Integer getScoreHomea() {
        return scoreHomea;
    }

    public void setScoreHomea(Integer scoreHomea) {
        this.scoreHomea = scoreHomea;
    }

    public Integer getScoreAwaya() {
        return scoreAwaya;
    }

    public void setScoreAwaya(Integer scoreAwaya) {
        this.scoreAwaya = scoreAwaya;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getDateGame() {
        return dateGame;
    }

    public void setDateGame(String dateGame) {
        this.dateGame = dateGame;
    }

    public boolean getFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}
