package com.project.model;

import java.io.Serializable;
import javax.persistence.Entity; 
import javax.persistence.GeneratedValue; 
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="games")
public class Game implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int gameId;
    private int round;
    private int scoreHomea;
    private int scoreAwaya;
    private String homeTeam;
    private String awayTeam;
    private String dateGame;
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

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }
    
    public int getRound() {
        return round;
    }
    
    public void setRound(int round) {
        this.round = round;
    }
    
    public int getScoreHomea() {
        return scoreHomea;
    }

    public void setScoreHomea(int scoreHomea) {
        this.scoreHomea = scoreHomea;
    }

    public int getScoreAwaya() {
        return scoreAwaya;
    }

    public void setScoreAwaya(int scoreAwaya) {
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

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
    
    @Override
    public String toString() {
        return "Game{" + "gameId=" + gameId + ", round=" + round + ", scoreHomea=" + scoreHomea + ", scoreAwaya=" + scoreAwaya + ", homeTeam=" + homeTeam + ", awayTeam=" + awayTeam + ", dateGame=" + dateGame + ", finished=" + finished + '}';
    }
}
