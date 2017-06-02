package com.project.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity; 
import javax.persistence.GeneratedValue; 
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="t_tasks")
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String homeTeam;
    private String awayTeam;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    private boolean finished;
    
    public Task() {
    }

    public Task(String homeTeam, String awayTeam, Date dateCreated, boolean finished) {
        super();
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.dateCreated = dateCreated;
        this.finished = finished;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", homeTeam=" + homeTeam + ", awayTeam=" + awayTeam + ", dateCreated=" + dateCreated + ", finished=" + finished + '}';
    }
}
