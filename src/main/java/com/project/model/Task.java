package com.project.model;

import java.io.Serializable;
import javax.persistence.Entity; 
import javax.persistence.GeneratedValue; 
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="t_tasks")
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int round;
    private int scoreHomea;
    private int scoreAwaya;
    private String homeTeam;
    private String awayTeam;
    private String dateMatch;
    private boolean finished;
    
    
    public Task() {
    }

    public Task(String homeTeam, String awayTeam, String dateMatch, boolean finished) {
        super();
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.dateMatch = dateMatch;
        this.finished = finished;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDateMatch() {
        return dateMatch;
    }

    public void setDateMatch(String dateMatch) {
        this.dateMatch = dateMatch;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
    
    /* @Override
    public String toString() {
    return "Task{" + "id=" + id + ", round=" + round + ", homeTeam=" + homeTeam + ", awayTeam=" + awayTeam + ", dateMatch=" + dateMatch + ", finished=" + finished + '}';
    }*/
    
    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", round=" + round + ", scoreHomea=" + scoreHomea + ", scoreAwaya=" + scoreAwaya + ", homeTeam=" + homeTeam + ", awayTeam=" + awayTeam + ", dateMatch=" + dateMatch + ", finished=" + finished + '}';
    }
}
